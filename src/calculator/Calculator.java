package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    double result;
    public double [] numArr = new double[2];
    private List resultList = new ArrayList();

    private final InputManager io;
    // 메서드 주입(선택적 의존성)
    public Calculator() {
        this.io = new InputManager(this);
    }


    public void calculator(double num1, double num2, char oper) {
        result = switch(oper) {
            case '+'-> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if(num2 == 0){
                    try {
                        throw new ArithmeticException(); // ✅ 예외발생
                    } catch (ArithmeticException e) {
                        yield -2;
                    }
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
