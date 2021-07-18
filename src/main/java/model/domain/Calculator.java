package model.domain;

import model.domain.operator.Operator;

import java.util.concurrent.atomic.AtomicInteger;

public class Calculator {
    private final Expression expression;
    private int answer;

    public Calculator(final Expression expression) {
        this.expression = expression;
        answer = expression.getOperands().getFirstElement();
    }

    public int calculate() {
        AtomicInteger index = new AtomicInteger();

        expression.getOperators()
                .stream()
                .forEach(operator -> parseOperator(operator, expression.getOperands().getElement(index.incrementAndGet())));

        return answer;
    }

    private void parseOperator(Operator operator, int operand) {
        if (operator.equals(Operator.PLUS)) {
            add(operand);
        } else if (operator.equals(Operator.MINUS)) {
            subtract(operand);
        } else if (operator.equals(Operator.TIMES)) {
            multiply(operand);
        } else if (operator.equals(Operator.DIVIDED_BY)) {
            divide(operand);
        }
    }

    private void add(final int operand) {
        this.answer += operand;
    }

    private void subtract(final int operand) {
        this.answer -= operand;
    }

    private void multiply(final int operand) {
        this.answer *= operand;
    }

    private void divide(final int operand) {
        if (operand == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }

        this.answer /= operand;
    }
}
