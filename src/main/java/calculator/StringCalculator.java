package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String NUMBER_REGEX = "\\d";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) return 0;

        String[] tokens = split(text);
        List<Integer> nums = parseIntoNums(tokens);
        return nums.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        Splitter splitter = new Splitter(text);
        return splitter.split();
    }

    private static List<Integer> parseIntoNums(String[] tokens) {
        List<Integer> nums = new ArrayList<>();
        for (String token : tokens) {
            validatePositiveNumber(token);
            nums.add(Integer.parseInt(token));
        }
        return nums;
    }

    private static void validatePositiveNumber(String token) {
        if (!Pattern.matches(NUMBER_REGEX, token) || Integer.parseInt(token) < 0)
            throw new RuntimeException();
    }
}
