package model.domain.operator;

import java.util.Arrays;

public enum Operator implements Operation {
    PLUS("+", Integer::sum),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDED_BY("/", Operator::divide);

    private final Operation operation;
    private final String symbol;

    Operator(final String symbol, final Operation operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Operator of(final String symbol) {
        return Arrays.stream(Operator.values())
                .filter(value -> value.symbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효한 연산자가 아닙니다"));
    }

    public String symbol() {
        return this.symbol;
    }

    @Override
    public int operate(int x, int y) {
        return operation.operate(x, y);
    }

    private static int divide(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }

        return x / y;
    }
}
