package model.domain.operation;

import model.domain.operator.Operator;

public class Division implements Operation {

    @Override
    public boolean hasOperator(final Operator operator) {
        return Operator.DIVIDED_BY == operator;
    }

    @Override
    public int operate(final int x, final int y) {
        if (y == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없음");
        }

        return x / y;
    }
}
