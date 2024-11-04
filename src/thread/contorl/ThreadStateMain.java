package thread.contorl;

import static util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState());  //new, start를 하지 않았기에.
        log("myThread start");
        thread.start();
        Thread.sleep(1000);
        log("myThread.state3 = " + thread.getState()); //mythread가 sleep 하는 중에 state. timed_waiting
        Thread.sleep(4000);
        log("myThread.state5 = " + thread.getState()); //시간 다 지나서 스레드 끝남.
        log("end");
    }

    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            try {
                log("start");
                log("myThread.state2 = " + Thread.currentThread().getState());
                log("sleep() start");
                Thread.sleep(3000);
                log("sleep() end");
                log("myThread.state4 = " + Thread.currentThread().getState());
                log("end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
