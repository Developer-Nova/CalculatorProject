package operator;

public class AddOperator implements UserOperator {

    @Override
    public double calculate(double firstValue, double secondValue) {
        return firstValue + secondValue;
    }
}
