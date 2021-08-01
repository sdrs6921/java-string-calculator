package model.domain;

import java.util.stream.IntStream;

public class Calculator {

    public Calculator() {
    }

    public int calculate(final Expression expression) {
        return IntStream.range(0, expression.operatorSize())
                .reduce(expression.firstOperand(),
                        (total, index) -> total = expression.operatorIndexOf(index).operate(total, expression.operandIndexOf(index + 1)));
    }
}
