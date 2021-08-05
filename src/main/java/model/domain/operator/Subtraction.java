package model.domain.operator;

public class Subtraction implements Operation {

    @Override
    public boolean hasOperator(Operator operator) {
        return Operator.MINUS == operator;
    }

    @Override
    public int operate(final int x, final int y) {
        return x - y;
    }
}
