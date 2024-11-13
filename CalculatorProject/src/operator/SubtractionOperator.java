package operator;

public class SubtractionOperator implements UserOperator {

    @Override
    public int calculate(int firstValue, int secondValue) {
        return firstValue - secondValue;
    }
}
