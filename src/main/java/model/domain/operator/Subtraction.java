package model.domain.operator;

public class Subtraction implements Operation {

    @Override
    public int operate(final int x, final int y) {
        return x - y;
    }
}
