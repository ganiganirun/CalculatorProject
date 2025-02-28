package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // while 종료 조건 변수
        boolean flag = true;
        Calculator calculator = new Calculator();
        IO io = new IO(calculator);

        while (flag){

            flag = io.inputMenu(flag);

        }
        System.out.println("계산기를 종료합니다.");

    }
}