package calculator;

import exception.DivisionByZeroException;
import operator.UserOperator;

public class CalculationContext {

    private UserOperator operator;
    private int firstValue;
    private int secondValue;

    public UserOperator getOperator() {
        return operator;
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

    public int calculate() throws DivisionByZeroException {
        return this.operator.calculate(this.firstValue, this.secondValue);
    }
}
