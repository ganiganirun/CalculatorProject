import calculator.HandleMenu;

public class Main {
    public static void main(String[] args) {
        // while 종료 조건 변수
        boolean flag = true;
        HandleMenu handleMenu = new HandleMenu();

        while (flag){

            flag = handleMenu.calculatorMenu(flag);

        }
        System.out.println("계산기를 종료합니다.");

    }
}