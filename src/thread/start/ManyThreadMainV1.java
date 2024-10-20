package thread.start;

import static util.MyLogger.*;

public class ManyThreadMainV1 {
    public static void main(String[] args) {
        log("main() start");

        //thread 3개 실행
        HelloRunnable runnable = new HelloRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        Thread thread3 = new Thread(runnable);
        thread3.start();

        log("main() end");
    }
}
