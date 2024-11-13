package calculator;

import exception.DivisionByZeroException;
import calculator.repository.Repository;
import exception.EmptyListException;
import exception.InvalidOperatorException;

public class Calculator {

    private final CalculationContext context = new CalculationContext();
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
        context.setFirstValue(Parser.parseFirstNum(value));
    }

    public void setSecondValue(int value) throws NumberFormatException {
        context.setSecondValue(Parser.parseSecondNum(value));
    }

    public void setOperator(String operator) throws InvalidOperatorException {
        context.setOperator(Parser.parseOperator(operator));
    }

    public int calculate() throws DivisionByZeroException {
        return list.addValue(context.calculate());
    }
}
