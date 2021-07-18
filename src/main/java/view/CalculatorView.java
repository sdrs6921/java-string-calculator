package view;

import java.util.Scanner;

public class CalculatorView {

    private static final String DELIMITER = " ";
    private static final Scanner SCANNER = new Scanner(System.in);

    public CalculatorView() {
    }

    public static String[] input() {
        String value = SCANNER.nextLine();
        return value.split(DELIMITER);
    }

    public static void printAnswer(int answer) {
        System.out.println(answer);
    }
}
