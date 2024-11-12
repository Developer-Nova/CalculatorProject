package operator;

public class DivideOperator implements UserOperator {

    @Override
    public int calculate(int firstValue, int secondValue) {
        return (secondValue != 0) ? firstValue / secondValue : 0;
    }
}
