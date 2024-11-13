package operator;

public enum Operator {
    ADD("+", new AddOperator()),
    SUBTRACTION("-", new SubtractionOperator()),
    DIVIDE("/", new DivideOperator()),
    MULTIPLY("*", new MultiplyOperator());

    private final UserOperator objectOperator;
    private final String stringOperator;

    Operator(String stringOperator, UserOperator objectOperator) {
        this.stringOperator = stringOperator;
        this.objectOperator = objectOperator;
    }

    public UserOperator getOperator() {
        return objectOperator;
    }

    public String getStringOperator() {
        return stringOperator;
    }
}
