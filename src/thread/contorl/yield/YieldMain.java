package thread.contorl.yield;

import static util.ThreadUtils.sleep;

public class YieldMain {
    static final int THREAD_COUNT = 1000;
    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                                //sleep이 없으면 스레드 하나가 상대적으로 오래 실행
//                sleep(1); //sleep이 들어가니 스레드 하나가 오래 실행못함.

                Thread.yield(); //다른 스레드에게 순서 양보, 스케줄링 큐로 다시 들어감
            }
        }
    }
}
