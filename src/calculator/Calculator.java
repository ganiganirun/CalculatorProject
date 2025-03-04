package calculator;

import io.OutputManager;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    double result;

    private List resultList = new ArrayList();

    OutputManager outputManager = new OutputManager();

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
        outputManager.printResult(num1,num2,oper,result);
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

    public String getResultList(int idx){
        return resultList.get(idx).toString();
    }

    public void removeResultList(int idx){
        resultList.remove(idx);
    }
}
