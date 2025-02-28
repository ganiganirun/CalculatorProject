package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    double result;
    public double [] numArr = new double[2];
    private List resultList = new ArrayList();
    Excep excep = new Excep();

    private final IO io;
    // 메서드 주입(선택적 의존성)
    public Calculator() {
        this.io = new IO(this);
    }

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

    public void calculator(double num1, double num2, char oper) {
        result = switch(oper) {
            case '+'-> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if(num2 == 0){
                    excep.callUncheckedException();
                    yield -2;
                }else{
                    yield num1 / num2;
                }
            }
            default -> -1;
        };
        io.printResult(num1,num2,oper,result);
        if (result != -1 && result != -2) {
            setResultList(result,oper);
        }
    }

    void setResultList(double result, char oper){
        if (oper == '+' || oper == '-'||oper == '*'){
            resultList.add((int)result);
        }else {
            resultList.add(result);

        }
    }

    String getResultList(int idx){
        return resultList.get(idx).toString();
    }

    void removeResultList(int idx){
        resultList.remove(idx);
    }







}
