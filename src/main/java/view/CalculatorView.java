package view;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class CalculatorView {

    private static final String DELIMITER = " ";
    private static final Scanner SCANNER = new Scanner(in);

    private CalculatorView() {
    }

    public static String[] input() {
        String value = SCANNER.nextLine();
        return value.split(DELIMITER);
    }

    public static void printAnswer(int answer) {
        out.println(answer);
    }
}
