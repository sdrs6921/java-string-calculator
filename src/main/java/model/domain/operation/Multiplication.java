package model.domain.operation;

import model.domain.operator.Operator;

public class Multiplication implements Operation {

    @Override
    public boolean hasOperator(Operator operator) {
        return Operator.TIMES == operator;
    }

    @Override
    public int operate(final int x, final int y) {
        return x * y;
    }
}
