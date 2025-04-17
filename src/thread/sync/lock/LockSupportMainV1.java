package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new PartTest(), "thread1");
        thread1.start();

        //잠시 대기해서 thread1이 park() 상태에 들어가도록 한다.
        sleep(1000);
        log("thread1 state : " + thread1.getState());

        log("main -> unpark(thread1)");

//        LockSupport.unpark(thread1);  //unpark()를 호출하면 park() 상태에서 runnable 상태로 변경된다.
        thread1.interrupt();
    }

    static class PartTest implements Runnable {
        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();  //이 코드를 호출하는 스레드는 runnable 상태에서 waiting 상태로 변경된다.
            log("park 종료, state : " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}
