package calculator;

import io.InputManager;

public class HandleMenu {
    InputManager inputManager = new InputManager();

    public double [] numArr = new double[2];

    public boolean calculatorMenu(boolean flag){
        int menu = inputManager.inputMenu();
        flag =  switch (menu) {
            case 1 -> {
                inputManager.inputNumArr(numArr);
                yield true;
            }
            case 2 -> {
                inputManager.seeResultList();
                yield true;
            }
            case 3 -> {
                inputManager.remoResultList();
                yield true;
            }
            case 4 -> inputManager.exitCalculator(flag);
            default -> {
                System.out.println("다시 입력해주세요.");
                yield true;
            }
        };
        return flag;
    }
}
