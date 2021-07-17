package model.domain;

import java.util.Arrays;
import java.util.List;

public class Expression {
    private static final int MIN_EXPRESSION_SIZE = 3;

    private final List<String> expression;

    public Expression(String[] s) {
        validateExpresion(s);
        expression = Arrays.asList(s);
    }

    private void validateExpresion(String[] s) {
        if (s.length < MIN_EXPRESSION_SIZE || hasEvenExpressionLength(s.length)) {
            throw new IllegalStateException("유효하지 않은 수식입니다");
        }
    }

    private boolean hasEvenExpressionLength(int size) {
        return size % 2 == 0;
    }
}
