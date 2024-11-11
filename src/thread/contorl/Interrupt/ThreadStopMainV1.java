package thread.contorl.Interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV1 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);
        log("작업 중단 지시 runFlag=false");

        //thread 안의 flag를 바꿔서 스레드 종료 시킴
        //이 방법은 즉각적으로 스레드 종료시키는 걸 보장하지 않음. (스레드가 3초 sleep중에 flag 변경하면 바로 끝나지 않음)
        task.runFlag = false;
    }

    static class MyTask implements Runnable {
        volatile boolean runFlag = true;

        @Override
        public void run() {
            while(runFlag){
                log("작업 중");
                sleep(3000);
            }

            log("자원 정리");
            log("자원 종료");
        }
    }
}
