package calculator.input;

import operator.UserOperator;

public class Input {

    private UserOperator operator;
    private int firstValue;
    private int secondValue;

    public UserOperator getOperator() {
        return operator;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setOperator(UserOperator operator) {
        this.operator = operator;
    }

    public void setFirstValue(int firstValue) {
        this.firstValue = firstValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }
}
