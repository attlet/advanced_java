package thread.contorl;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception{
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable{
        @Override
        public void run() /*throws Exception*/{   //runnable 인터페이스에서는 exception을 throw하려하면 컴파일 오류
//            throw new Exception();
        }

        /*
        자바에선 부모 클래스 메서드를 오버라이딩할 때, 부모 메서드가 체크 예외를 throw하지 않으면
        재정의한 자식 메서드도 체크 예외를 throw할 수 없음.
        부모 메서드가 체크 예외를 throw 한다면, 자식 메서드는 부모 메서드가 throw할 수 있는
        체크 예외의 하위 타입만 throw 가능.
         */
    }
}
