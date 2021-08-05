package model.domain.operation;

import model.domain.operator.Operator;

public class Subtraction implements Operation {

    @Override
    public boolean hasOperator(final Operator operator) {
        return Operator.MINUS == operator;
    }

    @Override
    public int operate(final int x, final int y) {
        return x - y;
    }
}
