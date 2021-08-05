package controller;

import model.domain.Expression;
import view.CalculatorView;

import static model.domain.Calculator.calculate;

public class CalculatorController {

    public void run() {
        String[] tokens = CalculatorView.input();
        Expression expression = new Expression(tokens);
        int answer = calculate(expression);
        CalculatorView.printAnswer(answer);
    }
}
