package calculator;

import exception.DivisionByZeroException;
import operator.UserOperator;

import java.util.LinkedList;

public class Calculator {

    private final LinkedList<Integer> resultList = new LinkedList<>();
    private UserOperator operator;
    private int firstValue;
    private int secondValue;

    public Calculator() {
    }

    public String getResultList() {
        return resultList.toString();
    }

    public int deleteFirstValue() {
        return this.resultList.removeFirst();
    }

    public void setFirstValue(int value) {
        this.firstValue = value;
    }

    public void setSecondValue(int value) {
        this.secondValue = value;
    }

    public void setOperator(UserOperator operator) {
        this.operator = operator;
    }

    public int calculate() {
        try {
            int result = operator.calculate(this.firstValue, this.secondValue);
            resultList.add(result);

            return result;
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
