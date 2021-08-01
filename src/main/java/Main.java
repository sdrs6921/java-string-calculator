import controller.CalculatorController;
import model.domain.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorController calculatorController = new CalculatorController(calculator);
        calculatorController.run();
    }
}
