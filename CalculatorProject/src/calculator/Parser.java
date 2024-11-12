package calculator;

import exception.InvalidOperatorException;
import operator.*;

public abstract class Parser {

    public static int parseFirstNum(int firstInput) throws NumberFormatException {
        return Integer.parseInt(String.valueOf(firstInput));
    }

    public static int parseSecondNum(int secondInput) throws NumberFormatException {
        return Integer.parseInt(String.valueOf(secondInput));
    }

    public static UserOperator parseOperator(String operationInput) throws InvalidOperatorException {
        switch (operationInput) {
            case "+" -> {
                return new AddOperator();
            }
            case "-" -> {
                return new SubtractionOperator();
            }
            case "/" -> {
                return new DivideOperator();
            }
            case "*" -> {
                return new MultiplyOperator();
            }
            default -> throw new InvalidOperatorException("올바르지 않은 연산자 입니다.");
        }
    }
}
