package controller;

import model.domain.Calculator;
import model.domain.Expression;
import view.CalculatorView;

public class CalculatorController {
    private final Calculator calculator;

    public CalculatorController(final Calculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        String[] tokens = CalculatorView.input();
        Expression expression = new Expression(tokens);
        int answer = calculator.calculate(expression);
        CalculatorView.printAnswer(answer);
    }
}
