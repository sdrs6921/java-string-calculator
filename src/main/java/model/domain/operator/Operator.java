package model.domain.operator;

import java.util.Arrays;

public enum Operator {
    PLUS("+", new Addition()),
    MINUS("-", new Subtraction()),
    TIMES("*", new Multiplication()),
    DIVIDED_BY("/", new Division());

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

    public int operate(int x, int y) {
        return operation.operate(x, y);
    }
}
