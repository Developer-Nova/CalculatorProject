package calculator;

import operator.UserOperator;

import java.util.LinkedList;

public class Calculator {

    private final LinkedList<Integer> resultList = new LinkedList<>();
    private final UserOperator operator;
    private int firstValue;
    private int secondValue;

    public Calculator(UserOperator operator) {
        this.operator = operator;
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

    public int calculate() {
        int result = operator.calculate(this.firstValue, this.secondValue);
        resultList.add(result);

        return result;
    }
}
