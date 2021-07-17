package model.domain.operator;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDED_BY("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return this.symbol;
    }
}
