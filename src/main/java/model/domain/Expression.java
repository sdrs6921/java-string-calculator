package model.domain;

import model.domain.operand.Operand;
import model.domain.operator.Operator;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Expression {
    private static final int MIN_EXPRESSION_SIZE = 3;
    private final List<Operand> operands;
    private final List<Operator> operators;

    public Expression(final String[] token) {
        validateExpression(token.length);
        this.operands = parseOperandFromTokens(token);
        this.operators = parseOperatorsFromTokens(token);
    }

    public List<Operand> getOperands() {
        return operands;
    }

    public List<Operator> getOperators() {
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
