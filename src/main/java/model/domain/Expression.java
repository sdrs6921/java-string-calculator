package model.domain;

import model.domain.operand.Operand;
import model.domain.operand.Operands;
import model.domain.operator.Operator;
import model.domain.operator.Operators;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Expression {
    private static final int MIN_EXPRESSION_SIZE = 3;
    private final Operands operands;
    private final Operators operators;

    public Expression(final String[] token) {
        validateExpression(token.length);
        this.operands = new Operands(parseOperandFromTokens(token));
        this.operators = new Operators(parseOperatorsFromTokens(token));
    }

    public Operands getOperands() {
        return operands;
    }

    public Operators getOperators() {
        return operators;
    }

    private void validateExpression(int size) {
        if (hasValidateExpressionLength(size)) {
            throw new IllegalStateException("유효하지 않은 수식입니다");
        }
    }

    private boolean hasValidateExpressionLength(int size) {
        return size % 2 == 0 || size < MIN_EXPRESSION_SIZE;
    }

    private List<Operator> parseOperatorsFromTokens(String[] tokens) {
        AtomicInteger index = new AtomicInteger();

        return Arrays.stream(tokens)
                .filter(token -> index.getAndIncrement() % 2 == 1)
                .map(Operator::of)
                .collect(Collectors.toList());
    }

    private List<Operand> parseOperandFromTokens(String[] tokens) {
        AtomicInteger index = new AtomicInteger();

        return Arrays.stream(tokens)
                .filter(token -> index.getAndIncrement() % 2 == 0)
                .map(Operand::valueOf)
                .collect(Collectors.toList());
    }

}
