package calculator.repository;

import exception.EmptyListException;

public interface Repository {

    double addValue(double value);

    String getList() throws EmptyListException;

    double deleteFirstValue() throws EmptyListException;
}
