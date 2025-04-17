package thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV6 implements BankAccount{
    private int balance;
    private final Lock lock = new ReentrantLock();

    public BankAccountV6(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) throws InterruptedException {
        log("거래 시작: " + getClass().getSimpleName());
        // 잔고가 출금액보다 적으면 false
        //tryLock()을 사용하여 락을 얻는 시도를 한다. 500ms 대기 후 락을 얻지 못하면 false를 반환한다.
        if (!lock.tryLock(500, TimeUnit.MILLISECONDS)) {
            log("[진입 실패] 이미 처리중인 작업이 있습니다.");
            return false;
        }

        try{
            log("[검증 시작] 출금액 : " + amount + ", 잔액 : " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }

            // 잔고가 출금액보다 많으면 출금 진행. true
            log("[검증 종료] 출금액 : " + amount + ", 잔액 : " + balance);
            sleep(1000); //출금할 때 걸리는 시간은 이만큼 걸린다고 가정

            balance = balance - amount;
            log("[출금 종료] 출금액 : " + amount + ", 잔액 : " + balance);

        } finally {
            lock.unlock(); //lock을 해제한다. finally를 통해 무조건 마지막에 unlock()이 호출되도록 한다.
        }
        log("거래 종료");
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try{
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
