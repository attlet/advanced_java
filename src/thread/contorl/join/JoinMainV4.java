package thread.contorl.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV4 {
    public static void main(String[] args) throws InterruptedException {
        log("start");
        SumTask task1 = new SumTask(1, 50);
        Thread thread1 = new Thread(task1, "thread-1");

        thread1.start();

        //스레드가 종료될 때 까지 main 스레드는 waiting 상태로 대기하는 join
        log("join() - main 스레드가 thread1  종료까지 1초 대기");

        //join을 통해 main스레드가 1초까지만 대기
        thread1.join(1000);
        log("main 스레드 대기 완료");
        log("task1.result = " + task1.result);
        log("end");
    }

    static class SumTask implements Runnable{
        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) { //java에선 this가 생략되어있는 것.
                sum += i;
            }
            result = sum;
            log("작업 완료 result = " + result);

            /*
            인스턴스 메서드 호출 시 스택 프레임 쌓임. 스택 프레임 안에 메서드와 인스턴스 참조값 this 정보 들어감.
             */
        }
    }
}
