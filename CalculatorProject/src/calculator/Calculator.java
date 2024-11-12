package calculator;

import operator.UserOperator;

import java.util.ArrayList;

public class Calculator {

    private final ArrayList<Integer> resultList = new ArrayList<>();
    private final UserOperator operator;
    private int firstValue;
    private int secondValue;

    public Calculator(UserOperator operator) {
        this.operator = operator;
    }

    public String getResultList() {
        return resultList.toString();
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
