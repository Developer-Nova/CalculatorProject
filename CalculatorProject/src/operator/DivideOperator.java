package operator;

import exception.DivisionByZeroException;

public class DivideOperator implements UserOperator {

    @Override
    public double calculate(double firstValue, double secondValue) throws DivisionByZeroException {
        if (secondValue == 0) {
            throw new DivisionByZeroException("0으로 나눌 수 없습니다.");
        }
        return firstValue / secondValue;
    }
}
