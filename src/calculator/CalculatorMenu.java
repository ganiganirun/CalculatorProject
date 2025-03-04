package calculator;

public class CalculatorMenu {

    public boolean calculatorMenu(int menu, boolean flag ){
        flag =  switch (menu) {
            case 1 -> {
                io.inputNumArr(numArr);
                yield true;
            }
            case 2 -> {
                io.seeResultList();
                yield true;
            }
            case 3 -> {
                io.remoResultList();
                yield true;
            }
            case 4 -> io.exitCalculator(flag);
            default -> {
                System.out.println("다시 입력해주세요.");
                yield true;
            }
        };
        return flag;
    }
}
