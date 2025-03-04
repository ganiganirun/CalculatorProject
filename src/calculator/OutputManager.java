package calculator;

public class OutputManager {
    public void printResult(double num1, double num2, char oper, double result){
        if (oper == '+' || oper == '-'||oper == '*'){
            System.out.println((int)num1 + " " + oper + " " + (int)num2 + " = " + (int)result);
        } else if (result == -1) {
            System.out.println("해당 연산은 본 계산기에 포함 되어 있지 않습니다.");
        } else if (result == -2) {
            System.out.println("0으로 나눌 수 없습니다.");
        } else{
            System.out.println((int)num1 + " " + oper + " " + (int)num2 + " = " + result);
        }

    }
}
