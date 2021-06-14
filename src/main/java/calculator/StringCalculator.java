package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        List<String> numbers = split(expression);
        assertThatNonNegativeIn(numbers);
        return sumOf(numbers);
    }

    private static List<String> split(String expression) {
        String customDelimeterRegex = "//(.)\n(.*)";
        Matcher matcher = Pattern.compile(customDelimeterRegex).matcher(expression);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return Arrays.asList(matcher.group(2).split(customDelimiter));
        }

        String defaultDelimiterRegex = ",|:";
        return Arrays.asList(expression.split(defaultDelimiterRegex));
    }

    private static void assertThatNonNegativeIn(List<String> numbers) {
        boolean hasNegativeNumber = numbers.stream()
                .mapToInt(Integer::parseInt)
                .anyMatch(number -> number < 0);

        if (hasNegativeNumber) {
            throw new RuntimeException();
        }
    }

    private static int sumOf(List<String> numbers) {
        return numbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
