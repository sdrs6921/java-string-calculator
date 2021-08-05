package model.domain;

import model.domain.operand.Operand;
import model.domain.operand.Operands;
import model.domain.operator.Operator;
import model.domain.operator.Operators;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Expression {
    private static final int START_ENTRY = 0;
    private static final int MIN_EXPRESSION_SIZE = 3;

    private final Operands operands;
    private final Operators operators;

    public Expression(final String[] token) {
        validateExpression(token.length);
        this.operands = new Operands(parseOperandFromTokens(token));
        this.operators = new Operators(parseOperatorsFromTokens(token));
    }

    public boolean hasNextOperand() {
        return operands.hasNext();
    }

    public int nextOperand() {
        return operands.next();
    }

    public boolean hasNextOperator() {
        return operators.hasNext();
    }

    public Operator nextOperator() {
        return operators.next();
    }

    private void validateExpression(int size) {
        if (hasValidateExpressionLength(size)) {
            throw new IllegalStateException("유효하지 않은 수식입니다");
        }
    }

    private boolean hasValidateExpressionLength(int size) {
        return size % 2 == 0 || size < MIN_EXPRESSION_SIZE;
    }

    private Queue<Operator> parseOperatorsFromTokens(String[] tokens) {
        return IntStream.range(START_ENTRY, tokens.length)
                .filter(index -> !hasEvenIndex(index))
                .mapToObj(index -> Operator.of(tokens[index]))
                .collect(Collectors.toCollection(LinkedList::new));
    }


    private Queue<Operand> parseOperandFromTokens(String[] tokens) {
        return IntStream.range(START_ENTRY, tokens.length)
                .filter(this::hasEvenIndex)
                .mapToObj(index -> Operand.valueOf(tokens[index]))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private boolean hasEvenIndex(int index) {
        return index % 2 == 0;
    }
}
