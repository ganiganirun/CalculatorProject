package io;

import calculator.Calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputManager {
    Scanner scn = new Scanner(System.in);

    Calculator calculator = new Calculator();

    public int inputMenu(){
        System.out.println("원하시는 메뉴의 번호를 입력해주세요.\n1: 연산하기 2: 기록보기 3: 기록삭제하기 4: 계산기 종료");
        int idx = scn.nextInt();
        scn.nextLine();

        return idx;
    }

    public void inputNumArr(double[] numArr){
        while (true) {
            try {
                System.out.print("양의 정수를 두개 입력하시오. ");

                for (int i = 0; i < numArr.length; i++) {
                    numArr[i] = scn.nextInt();
                }
                scn.nextLine();
                inputOper(numArr);
                break;
            }catch (InputMismatchException e){
                System.out.println("양의 정수 이외의 값은 입력할 수 없습니다.");
                scn.nextLine();
            }
        }
    }

    public void inputOper(double[] numArr){
        System.out.print("+,-,*,/ 중 하나를 입력하시오.");
        char oper = scn.next().charAt(0);
        scn.nextLine(); // 버퍼비우기
        calculator.calculator(numArr[0],numArr[1],oper);
    }

    public void seeResultList(){
        System.out.println("몇 번째 연산 결과를 보시겠습니까? :");
        int idx = scn.nextInt();
        scn.nextLine();
        System.out.println(calculator.getResultList(idx-1));
    }

    public void remoResultList(){
        System.out.println("몇 번째 연산 결과를 삭제하시겠습니까?");
        int idx = scn.nextInt();
        scn.nextLine();
        System.out.println(calculator.getResultList(idx-1));
        calculator.removeResultList(idx-1);

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
