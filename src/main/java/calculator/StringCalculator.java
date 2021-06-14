package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String delimiters = ",|:";
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (matcher.find()) {
            delimiters += "|" + matcher.group(1);
            return matcher.group(2).split(delimiters);
        }
        return text.split(delimiters);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }
}
