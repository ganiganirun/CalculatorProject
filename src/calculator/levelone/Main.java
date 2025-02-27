package calculator.levelone;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // while 종료 조건 변수
        boolean flag = true;

        while (flag){
            int[] numArr = new int[2];
            int result = 0;

            // 정수형이 아닌 것을 입력받을 시 발생하는 오류 예외 처리
            while (true) {
                try {
                    System.out.print("양의 정수를 두개 입력하시오. ");

                    for (int i = 0; i < numArr.length; i++) {
                        numArr[i] = scn.nextInt();
                    }
                    break;
                }catch (InputMismatchException e){
                    System.out.println("양의 정수 이외의 값은 입력할 수 없습니다.");

                    // while을 통해서 예외 발생시 반복할 때 scanner를 초기화 시켜줘야 무한루프 빠져나옴
                    scn.nextLine();
                }
            }

            scn.nextLine();

            // 사칙연산 기호 입력 받기
            System.out.print("+,-,*,/ 중 하나를 입력하시오.");
            char oper = scn.next().charAt(0);

            scn.nextLine();


            switch (oper){
                case '+':
                    result = numArr[0] + numArr[1];
                    System.out.println(numArr[0] + " + " + numArr[1] + " = " + result);
                    break;
                case '-':
                    result = numArr[0] - numArr[1];
                    System.out.println(numArr[0] + " - " + numArr[1] + " = " + result);
                    break;
                case '*':
                    result = numArr[0] * numArr[1];
                    System.out.println(numArr[0] + " * " + numArr[1] + " = " + result);
                    break;
                case '/':
                    // 0으로 나누려고 할 경우 오류 예외 처리
                    try{
                        // 나누기의 경우 실수가 나올 수 있기 때문에 자료형을 double로 업캐스팅
                        double num1 = numArr[0];
                        double num2 = numArr[1];
                        double result1 = num1 / num2;

                        // 실수의 나눗셈 0으로 나눌 시 infinity 또는 nan값이 나와 일부러 예외를 발생시켜 예외처리
                        if(Double.isInfinite(result1) || Double.isNaN(result1)){
                            throw new ArithmeticException();
                        }
                        System.out.println(numArr[0] + " / " + numArr[1] + " = " + result1);
                        break;
                    } catch (ArithmeticException e){
                        System.out.println("0으로 나눌 수 없습니다.");
                        break;
                    }
                default:
                    System.out.println("해당 연산은 본 계산기에 포함 되어 있지 않습니다.");


            }
            // while 문 종료 조건 부분
            // ex의 값이 exit와 같으면 flag의 값을 false로 변경하여 while문 종료.
            System.out.print("졸료를 원할 시 exit를 입력하시오. 아닐 시 enter를 누르시오.");
            String ex = scn.nextLine();
            if(ex.equals("exit")){
                flag = false;
            }
        }
        System.out.println("계산기를 종료합니다.");
        // scanner 종료.
        scn.close();
    }
}

