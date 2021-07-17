package view;

import java.util.Scanner;

public class CalculatorView {
    private final Scanner scanner;

    public CalculatorView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public void input() {
        String value = scanner.nextLine();
        String[] values = value.split(" ");
    }
}
