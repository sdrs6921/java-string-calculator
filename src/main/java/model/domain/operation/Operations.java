package model.domain.operation;

import model.domain.operator.Operator;

import java.util.Arrays;
import java.util.List;

public class Operations {

    private Operations() {
    }

    private static final List<Operation> OPERATION_STRATEGIES
            = Arrays.asList(new Addition(), new Subtraction(), new Multiplication(), new Division());

    public static Operation findOperation(final Operator operator) {
        return OPERATION_STRATEGIES.stream()
                .filter(operation -> operation.hasOperator(operator))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("유효한 연산자가 아닙니다"));
    }
}
