package thread.contorl.join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMainV1 {
    public static void main(String[] args) {
        log("start");
        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);

        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

        log("task1.result = " + task1.result);
        log("task2.result = " + task2.result);

        int sumAll = task1.result + task2.result;
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
