package operator;

public class MultiplyOperator implements UserOperator {

    @Override
    public double calculate(double firstValue, double secondValue) {
        return firstValue * secondValue;
    }
}
