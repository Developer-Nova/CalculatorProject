package operator;

public class MultiplyOperator implements UserOperator {

    @Override
    public int calculate(int firstValue, int secondValue) {
        return firstValue * secondValue;
    }
}
