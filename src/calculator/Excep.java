package calculator;

public class Excep {

    public void callUncheckedException() {
        try {
            throw new ArithmeticException(); // ✅ 예외발생
        } catch (ArithmeticException e) {
            
        }
    }
}
