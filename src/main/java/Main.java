import view.CalculatorView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculatorView calculatorView = new CalculatorView(scanner);
        calculatorView.input();
    }
}
