package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    double result;
    public double [] numArr = new double[2];
    // 어느 객체든 저장할 수 있는 ArrayList가 되어 버린다.
    private List resultList = new ArrayList();
    //IO io = new IO();
    Excep excep = new Excep();
    private IO io;

    public Calculator() {
        this.io = new IO(this); // `this`를 넘겨서 IO가 현재 Calculator를 참조하도록 함
    }

    public void calculator(double num1, double num2, char oper) {
        result = switch(oper) {
            case '+'-> sum(num1,num2);
            case '-' -> sub(num1,num2);
            case '*' -> mul(num1,num2);
            case '/' -> {
                if(num2 == 0){
                    excep.callUncheckedException();
                    yield -2;
                }else{
                    yield div(num1,num2);
                }
            }
            default -> -1;
        };
        io.printResult(num1,num2,oper,result);
        if (result != -1 && result != -2) {
            setResultList(result,oper);
        }
    }

    public boolean calculatorMenu(int menu, boolean flag){
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
