package calculator;

import java.util.Arrays;

public class StringCalculator {

    public static int splitAndSum(String expression) {
        int result = 0;

        if (expression == null || expression.isEmpty()) {
            return result;
        }

        String[] numbers = expression.split(",|:");
        result += add(numbers);
        return result;
    }

    private static int add(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
