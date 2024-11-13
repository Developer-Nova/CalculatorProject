package calculator;

import exception.InvalidOperatorException;
import operator.*;

import java.util.EnumSet;

public class Parser {

    private Parser() {
    }

    public static int parseFirstNum(int firstInput) throws NumberFormatException {
        return Integer.parseInt(String.valueOf(firstInput));
    }

    public static int parseSecondNum(int secondInput) throws NumberFormatException {
        return Integer.parseInt(String.valueOf(secondInput));
    }

    public static UserOperator parseOperator(String operationInput) throws InvalidOperatorException {
        return EnumSet.allOf(Operator.class).stream()
                .filter(operator -> operator.getStringOperator().equals(operationInput))
                .findFirst()
                .orElseThrow(() -> new InvalidOperatorException("올바르지 않은 연산자 입니다."))
                .getOperator();
    }
}
