package calculator.repository;

import exception.EmptyListException;

import java.util.LinkedList;

public class ResultRepository implements Repository {

    private final LinkedList<Integer> list = new LinkedList<>();

    @Override
    public int addValue(int value) {
        list.add(value);
        return value;
    }

    @Override
    public String getList() throws EmptyListException {
        if (list.isEmpty()) {
            throw new EmptyListException("리스트가 비어있습니다.");
        }
        return list.toString();
    }

    @Override
    public int deleteFirstValue() throws EmptyListException {
        if (list.isEmpty()) {
            throw new EmptyListException("리스트가 비어있습니다.");
        }
        return list.removeFirst();
    }
}
