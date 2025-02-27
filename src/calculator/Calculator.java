package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
//    double num1 ;
//    double num2 ;
//    char oper;
    double result;
    // 어느 객체든 저장할 수 있는 ArrayList가 되어 버린다.
    List list = new ArrayList();
    IO io = new IO();




    public void calculator(double num1, double num2, char oper) {

        result = switch(oper) {
            case '+'-> sum(num1,num2);
            case '-' -> sub(num1,num2);
            case '*' -> mul(num1,num2);
            case '/' -> div(num1,num2);
            default -> -1;
        };
        io.printResult(num1,num2,oper,result);


    }

    private double sum(double num1, double num2){
        result = num1 + num2;
        return result;
    }

    private double sub (double num1, double num2){
        result = num1 - num2;
        return result;
    }

    private double mul(double num1, double num2){
        result = num1 * num2;
        return result;
    }

    private double div(double num1, double num2){
        result = num1 / num2;
        return result;
    }




}
