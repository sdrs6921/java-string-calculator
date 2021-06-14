package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        String[] numbers = split(expression);
        assertThatNonNegativeIn(numbers);
        return sumOf(numbers);
    }

    private static String[] split(String expression) {
        String customDelimeterRegex = "//(.)\n(.*)";
        Matcher matcher = Pattern.compile(customDelimeterRegex).matcher(expression);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        String defaultDelimiterRegex = ",|:";
        return expression.split(defaultDelimiterRegex);
    }

    private static void assertThatNonNegativeIn(String[] numbers) {
        boolean hasNegativeNumber = Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .anyMatch(number -> number < 0);

        if (hasNegativeNumber) {
            throw new RuntimeException();
        }
    }

    private static int sumOf(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
