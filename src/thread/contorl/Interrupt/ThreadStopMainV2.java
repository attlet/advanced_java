package thread.contorl.Interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(4000);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();  //인터럽트. sleep에 상관없이 바로 작업 중단
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {
        volatile boolean runFlag = true;

        @Override
        public void run() {
            try{
                while(true){   //무한 루프
                    log("작업 중");
                    Thread.sleep(3000);
                }
            } catch(InterruptedException e){
                //인터럽트 걸려서 깨어남, interrupted는 false로 됨.
                log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());
                log("interrupt message=" + e.getMessage());
                log("state=" + Thread.currentThread().getState());
            }
            log("자원 정리");



            log("자원 정리");
            log("자원 종료");
        }
    }
}
