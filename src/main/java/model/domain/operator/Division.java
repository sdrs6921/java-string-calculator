package model.domain.operator;

public class Division implements Operation {

    @Override
    public int operate(final int x, final int y) {
        if (y == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없음");
        }

        return x / y;
    }
}
