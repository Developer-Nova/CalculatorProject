package operator;

import exception.DivisionByZeroException;

public interface UserOperator {

    int calculate(int firstValue, int secondValue) throws DivisionByZeroException;
}
