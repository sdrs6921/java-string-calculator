package model.domain.operator;

public interface Operation {

    boolean hasOperator(final Operator operator);

    int operate(final int x, final int y);
}
