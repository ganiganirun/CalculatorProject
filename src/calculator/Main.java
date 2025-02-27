package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // while 종료 조건 변수
        boolean flag = true;
        Calculator calculator = new Calculator();
        IO io = new IO();

        while (flag){
            double [] numArr = new double[2];
            double result = 0;

            numArr = io.inputNumArr(numArr);
            char oper = io.inputOper();
            calculator.calculator(numArr[0],numArr[1],oper);
            flag = io.exitCalculator(flag);

        }
        System.out.println("계산기를 종료합니다.");

    }
}