package model.domain.operator;

public class Addition implements Operation {

    @Override
    public boolean hasOperator(Operator operator) {
        return Operator.PLUS == operator;
    }

    @Override
    public int operate(final int x, final int y) {
        return x + y;
    }
}
