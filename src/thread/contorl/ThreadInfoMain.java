package thread.contorl;

import thread.start.HelloRunnable;

import static util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {
        //main 스레드 정보
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.threadId()=" + mainThread.threadId()); // 자바 내부적으로 만들고, 중복되지 않음
        log("mainThread.getName()=" + mainThread.getName()); //스레드 이름은 중복 가능
        log("mainThread.getPriority()=" + mainThread.getPriority());  //우선순위. 기본은 5이고 높을 수록 cpu가 많이 실행. 우리가 조정할 일은 거의 없음. 운영체제가 알아서 최적화.
        log("mainThread.getThreadGroup()=" + mainThread.getThreadGroup());
        log("mainThread.getState()=" + mainThread.getState());

        //myThread
        Thread myThread = new Thread(new HelloRunnable(), "myThread");

        log("myThread = " + myThread);
        log("myThread.threadId()=" + myThread.threadId()); // 자바 내부적으로 만들고, 중복되지 않음
        log("myThread.getName()=" + myThread.getName()); //스레드 이름은 중복 가능
        log("myThread.getPriority()=" + myThread.getPriority());  //우선순위. 기본은 5이고 높을 수록 cpu가 많이 실행. 우리가 조정할 일은 거의 없음. 운영체제가 알아서 최적화.
        log("myThread.getThreadGroup()=" + myThread.getThreadGroup());
        log("myThread.getState()=" + myThread.getState()); //thread 생성 후 실행을 안 해서 new라 나타남


    }
}
