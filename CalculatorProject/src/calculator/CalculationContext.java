package calculator;

import exception.DivisionByZeroException;
import operator.UserOperator;

public class CalculationContext {

    private UserOperator operator;
    private double firstValue;
    private double secondValue;

    public void setOperator(UserOperator operator) {
        this.operator = operator;
    }

    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    public void setSecondValue(double secondValue) {
        this.secondValue = secondValue;
    }

    public double calculate() throws DivisionByZeroException {
        return this.operator.calculate(this.firstValue, this.secondValue);
    }
}
