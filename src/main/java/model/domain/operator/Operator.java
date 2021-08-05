package model.domain.operator;

import java.util.Arrays;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDED_BY("/");

    private final String symbol;

    Operator(final String symbol) {
        this.symbol = symbol;
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
}
