package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // while 종료 조건 변수
        boolean flag = true;
        Calculator calculator = new Calculator();

        while (flag){
            double [] numArr = new double[2];
            double result = 0;

            // 정수형이 아닌 것을 입력받을 시 발생하는 오류 예외 처리
            while (true) {
//                 // 무한루프 나가기 시도 2
//                for(int i = 0; i < numArr.length; i++){
//                    numArr[i] = 0;
//                }

                try {
                    System.out.print("양의 정수를 두개 입력하시오. ");

                    for (int i = 0; i < numArr.length; i++) {
                        numArr[i] = scn.nextInt();

//                        //무한루프 나가기 시도 1
//                        int a = scn.nextInt();
//                        numArr[i] = a;
                    }
                    break;
                }catch (InputMismatchException e){
                    System.out.println("양의 정수 이외의 값은 입력할 수 없습니다.");

                    // while을 통해서 예외 발생시 반복할 때 scanner를 초기화 시켜줘야 무한루프가 안돌아감
                    // 블로그 정보 참고
//                    scn = new Scanner(System.in); // 얘로 해도 무한루프 탈출 가능함
                    scn.nextLine(); // 애로 해도 무한루프 탈출 가능함 -> 근데 얘가 더 효율적
                }
            }

            scn.nextLine(); // 버퍼비우기

            // 사칙연산 기호 입력 받기
            System.out.print("+,-,*,/ 중 하나를 입력하시오.");
            char oper = scn.next().charAt(0);

            scn.nextLine(); // 버퍼비우기

            calculator.calculator(numArr[0],numArr[1],oper);

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