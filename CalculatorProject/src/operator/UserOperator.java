package operator;

import exception.DivisionByZeroException;

public interface UserOperator {

    double calculate(double firstValue, double secondValue) throws DivisionByZeroException;
}
