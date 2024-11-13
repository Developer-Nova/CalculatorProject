package calculator.repository;

import exception.EmptyListException;

public interface Repository {

    int addValue(int value);

    String getList() throws EmptyListException;

    int deleteFirstValue() throws EmptyListException;
}
