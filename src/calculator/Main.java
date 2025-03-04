package calculator;

public class Main {
    public static void main(String[] args) {
        // while 종료 조건 변수
        boolean flag = true;
        Calculator calculator = new Calculator();
        InputManager io = new InputManager(calculator);

        while (flag){

            flag = io.inputMenu(flag);

        }
        System.out.println("계산기를 종료합니다.");

    }
}