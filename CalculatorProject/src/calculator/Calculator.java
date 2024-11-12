package calculator;

import operator.UserOperator;

import java.util.ArrayList;

public class Calculator {

    private final ArrayList<Integer> resultList = new ArrayList<>();
    private final UserOperator operator;
    private Integer firstValue;
    private Integer secondValue;

    public Calculator(UserOperator operator) {
        this.operator = operator;
    }

    public void setFirstValue(Integer value) {
        this.firstValue = value;
    }

    public void setSecondValue(Integer value) {
        this.secondValue = value;
    }

    public void calculate() {
        operator.calculate(this.firstValue, this.secondValue);
    }
}
