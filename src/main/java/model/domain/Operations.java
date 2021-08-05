package model.domain;

import model.domain.operator.Addition;
import model.domain.operator.Division;
import model.domain.operator.Multiplication;
import model.domain.operator.Operation;
import model.domain.operator.Operator;
import model.domain.operator.Subtraction;

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
