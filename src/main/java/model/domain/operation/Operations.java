package model.domain.operation;

import model.domain.operator.Operator;

import java.util.Arrays;
import java.util.List;

public class Operations {

    private Operations() {
    }

    private static final List<Operation> OPERATIONS
            = Arrays.asList(new Addition(), new Subtraction(), new Multiplication(), new Division());

    public static Operation findOperation(Operator operator) {
        return OPERATIONS.stream()
                .filter(operation -> operation.hasOperator(operator))
                .findAny()
                .orElseThrow();
    }
}
