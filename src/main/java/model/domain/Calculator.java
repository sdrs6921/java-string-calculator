package model.domain;

import model.domain.operation.Operation;
import model.domain.operator.Operator;

import static model.domain.operation.Operations.findOperation;

public class Calculator {

    private Calculator() {
    }

    public static int calculate(final Expression expression) {
        int answer = expression.nextOperand();

        while (expression.hasNextOperand()) {
            Operator operator = expression.nextOperator();
            int nextOperand = expression.nextOperand();
            Operation operation = findOperation(operator);
            answer = operation.operate(answer, nextOperand);
        }

        return answer;
    }
}
