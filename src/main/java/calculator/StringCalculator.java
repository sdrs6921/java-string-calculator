package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String CUSTOM_DELIMETER_REGEX = "//(.)\n(.*)";
    private static final String DEFAULT_DELIMITER_REGEX = ",|:";

    public static int splitAndSum(String expression) {
        if (expression == null || expression.isEmpty()) {
            return 0;
        }

        String[] numbers = split(expression);
        assertThatNonNegativeIn(numbers);
        return sumOf(numbers);
    }

    private static String[] split(String expression) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMETER_REGEX).matcher(expression);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return expression.split(DEFAULT_DELIMITER_REGEX);
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
