package thread.start;

import static util.MyLogger.log;
public class InnerRunnableMainV1 {
    public static void main(String[] args) {
        log("main() start");
        MyRunnalbe myRunnalbe = new MyRunnalbe();
        Thread thread = new Thread(myRunnalbe);
        thread.start();

        log("main() end");
    }

    static class MyRunnalbe implements Runnable{
        @Override
        public void run(){
            log(Thread.currentThread().getName() + ": run()");
        }
    }

}
