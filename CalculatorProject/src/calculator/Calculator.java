package calculator;

import calculator.input.Input;
import exception.DivisionByZeroException;
import calculator.repository.Repository;
import exception.EmptyListException;
import exception.InvalidOperatorException;

public class Calculator {

    private final Input input = new Input();
    private final Repository list;

    public Calculator(Repository list) {
        this.list = list;
    }

    public String getList() throws EmptyListException {
        return list.getList();
    }

    public int deleteFirstValue() throws EmptyListException {
        return list.deleteFirstValue();
    }

    public void setFirstValue(int value) throws NumberFormatException {
        input.setFirstValue(Parser.parseFirstNum(value));
    }

    public void setSecondValue(int value) throws NumberFormatException {
        input.setSecondValue(Parser.parseSecondNum(value));
    }

    public void setOperator(String operator) throws InvalidOperatorException {
        input.setOperator(Parser.parseOperator(operator));
    }

    public int calculate() throws DivisionByZeroException {
        return list.addValue(input.getOperator().calculate(input.getFirstValue(), input.getSecondValue()));
    }
}
