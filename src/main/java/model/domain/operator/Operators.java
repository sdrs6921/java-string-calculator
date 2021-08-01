package model.domain.operator;

import java.util.List;
import java.util.stream.Stream;

public class Operators {
    private static final int FIRST_INDEX = 0;
    private final List<Operator> operators;

    public Operators(List<Operator> operators) {
        this.operators = operators;
    }

    public Operator indexOf(int index) {
        if (isIndexOutOfRange(index)) {
            throw new IllegalArgumentException("범위를 초과한 index 입니다");
        }

        return operators.get(index);
    }

    public int size() {
        return operators.size();
    }

    public Stream<Operator> stream() {
        return operators.stream();
    }

    private boolean isIndexOutOfRange(int index) {
        return index < FIRST_INDEX || index >= size();
    }
}
