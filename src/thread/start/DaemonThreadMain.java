package thread.start;

public class DaemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        DaemonThread daemonThread = new DaemonThread();

        daemonThread.setDaemon(true); //데몬 스레드로 설정. 그러자 10초 안 지나도 java는 종료됨.
        daemonThread.start();
        System.out.println(Thread.currentThread().getName() + ": main() end ");
    }
    static class DaemonThread extends Thread {
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName() + ": run()");

            try{
                Thread.sleep(10000);

            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }

}
