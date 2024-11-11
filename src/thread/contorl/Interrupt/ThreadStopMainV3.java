package thread.contorl.Interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3 {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(100);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();  //인터럽트. sleep에 상관없이 바로 작업 중단
        log("work 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {
        volatile boolean runFlag = true;

        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                //인터럽트 상태 체크

                log("작업 중");
            }
            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted()); //여전히 interrupt 상태 true 유지

            //위에서 interrupt상태가 계속 true라 이 다음 코드에서
            //InterruptException을 터뜨릴 수 있는 thread.sleep같은 메서드가 있으면, 바로
            //exception이 터지게 됨.
            try{
                while(true){   //무한 루프
                    log("작업 중");
                    Thread.sleep(3000);   //여기서 바로 터짐
                }
            } catch(InterruptedException e){
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());

            }

            log("자원 정리");
            log("자원 종료");
        }
    }
}
