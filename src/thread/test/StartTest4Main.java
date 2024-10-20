package thread.test;

import static util.MyLogger.log;

public class StartTest4Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Work("A", 1000), "Thread-A");
        Thread thread2 = new Thread( new Work("B", 500), "Thread-B");

        thread1.start();
        thread2.start();

    }

    static class Work implements Runnable {
        String name;
        int sleep;
        public Work(String name, int sleep){
            this.name = name;
            this.sleep = sleep;
        }
        @Override
        public void run() {
            while (true) {
                log(name);
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
