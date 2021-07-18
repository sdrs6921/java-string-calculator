package model.domain.operator;

import java.util.List;
import java.util.stream.Stream;

public class Operators {
    private final List<Operator> operators;

    public Operators(List<Operator> operators) {
        this.operators = operators;
    }

    public String getElement(int index) {
        return operators.get(index).symbol();
    }

    public int getOperatorsSize() {
        return operators.size();
    }

    public Stream<Operator> stream() {
        return operators.stream();
    }
}
