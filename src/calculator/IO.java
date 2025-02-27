package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {

    Scanner scn = new Scanner(System.in);
    public double[] inputNumArr(double[] numArr){
        while (true) {
            try {
                System.out.print("양의 정수를 두개 입력하시오. ");

                for (int i = 0; i < numArr.length; i++) {
                    numArr[i] = scn.nextInt();
                }
                scn.nextLine(); // 버퍼비우기
                break;
            }catch (InputMismatchException e){
                System.out.println("양의 정수 이외의 값은 입력할 수 없습니다.");
                scn.nextLine(); // 애로 해도 무한루프 탈출 가능함 -> 근데 얘가 더 효율적
            }
        }
        return numArr;
    }

    public char inputOper(){
        System.out.print("+,-,*,/ 중 하나를 입력하시오.");
        char oper = scn.next().charAt(0);
        scn.nextLine(); // 버퍼비우기

        return oper;
    }

    public void printResult(double num1, double num2, char oper, double result){
        // equals()은 string 함수라 char 비교시에는 사용 불가능
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

    public boolean exitCalculator(boolean flag){
        System.out.print("졸료를 원할 시 exit를 입력하시오. 아닐 시 enter를 누르시오.");
        String ex = scn.nextLine();
        if (ex.equals("exit")){
            flag = false;
        }
        return flag;
    }


}
