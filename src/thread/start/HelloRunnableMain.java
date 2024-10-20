package thread.start;

public class HelloRunnableMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloRunnable runnable = new HelloRunnable();
        Thread thread = new Thread(runnable); //runnable 작업을 매개변수로 넘길 수 있음
        thread.start();

        System.out.println(Thread.currentThread().getName() + ": main() end");

    }
}
