package model.domain.operation;

import model.domain.operator.Operator;

public interface Operation {

    boolean hasOperator(final Operator operator);

    int operate(final int x, final int y);
}
