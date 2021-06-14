package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) return 0;
        String[] tokens = split(text);
        return sum(tokens);
    }

    private static int sum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) sum += Integer.parseInt(token);
        return sum;
    }

    private static String[] split(String text) {
        List<String> delimiters = Arrays.asList(",", ":");
        String delimiterPattern = buildDelimiterPattern(delimiters);
        return text.split(delimiterPattern);
    }

    private static String buildDelimiterPattern(List<String> delimiters) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String delimiter : delimiters) sb.append(delimiter);
        sb.append("]");
        return sb.toString();
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
