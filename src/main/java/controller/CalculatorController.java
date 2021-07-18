package controller;

import model.domain.Calculator;
import model.domain.Expression;
import view.CalculatorView;

public class CalculatorController {
    private Calculator calculator;

    public CalculatorController() {
    }

    public void run() {
        setUpCalculator();
        int answer = calculator.calculate();
        CalculatorView.printAnswer(answer);
    }

    private void setUpCalculator() {
        String[] tokens = CalculatorView.input();
        Expression expression = new Expression(tokens);
        calculator = new Calculator(expression);
    }

}
