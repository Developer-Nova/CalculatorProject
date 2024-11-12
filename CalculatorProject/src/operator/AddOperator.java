package operator;

public class AddOperator implements UserOperator {

    @Override
    public int calculate(int firstValue, int secondValue) {
        return firstValue + secondValue;
    }
}
