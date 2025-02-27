package calculator;

public class IO {

    public void printResult(double num1, double num2, char oper, double result){
        // equals()은 string 함수라 char 비교시에는 사용 불가능
        if (oper == '+' || oper == '-'||oper == '*'){
            System.out.println((int)num1 + " " + oper + " " + (int)num2 + " = " + (int)result);
        } else if (result == -1) {


        } else{
            System.out.println((int)num1 + " " + oper + " " + (int)num2 + " = " + result);
        }

    }
}
