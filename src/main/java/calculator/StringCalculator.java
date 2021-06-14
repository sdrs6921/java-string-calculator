package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) return 0;
        String[] tokens = split(text);
        return sum(tokens);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        String delimiters = ",|:";
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            delimiters += "|" + matcher.group(1);
            return matcher.group(2).split(delimiters);
        }
        return text.split(delimiters);
    }

    private static int sum(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            if (!Pattern.matches("^[0-9]+$", token)) throw new RuntimeException();

            int num = Integer.parseInt(token);
            if (num < 0) throw new RuntimeException();

            sum += num;
        }
        return sum;
    }
}
