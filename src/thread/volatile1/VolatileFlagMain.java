package thread.volatile1;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileFlagMain {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread t = new Thread(task, "work");
        log("runFlag = " + task.runFlag);
        t.start();

        sleep(1000);
        log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);
        log("main 종료");

    }

    static class MyTask implements Runnable{
//        boolean runFlag = true;
        volatile boolean runFlag = true;
        @Override
        public void run() {
            log("task 시작");
            while(runFlag){
                //runFlag가 false로 변하면 탈출, 스레드 종료
                //이 안에 print 등 작업을 하면, 작업하는 동안 스레드가 잠시 대기 -> 컨텍스트 스위칭 발생 가능성 높아짐.
                //컨텍스트 스위칭 발생 시, 캐시 메모리의 값을 메인 메모리에 반영 -> while 문 탈출할 수 도 있음.
            }
            log("task 종료");
        }
    }
}
