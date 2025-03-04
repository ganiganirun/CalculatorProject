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
                try {
                    inputManager.viewResultList();
                    yield true;
                }catch (IndexOutOfBoundsException ex){
                    System.out.println("찾으시는 인덱스는 존재하지 않습니다.");
                    yield true;
                }

            }
            case 3 -> {
                try {
                    inputManager.deleteResultList();
                    yield true;
                }catch (IndexOutOfBoundsException ex){
                    System.out.println("찾으시는 인덱스는 존재하지 않습니다.");
                    yield true;
                }
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
