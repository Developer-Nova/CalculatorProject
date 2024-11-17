package operator;

public class SubtractionOperator implements UserOperator {

    @Override
    public double calculate(double firstValue, double secondValue) {
        return firstValue - secondValue;
    }
}
