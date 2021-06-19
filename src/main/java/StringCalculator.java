import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String POSITIVE_NUMBER_REX = "^[0-9]*$";
    private static final String DELIMITER = "[,:]";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (StringUtils.isEmpty(input)) {
            return 0;
        }
        return sum(split(input));
    }

    private static String[] split(String input) {
        String[] tokens = input.split(DELIMITER);
        Matcher m = CUSTOM_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }
        return tokens;
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens).mapToInt(t -> getPositiveNumber(t)).sum();
    }

    private static int getPositiveNumber(String token) {
        if (!Pattern.matches(POSITIVE_NUMBER_REX, token)) {
            throw new RuntimeException("양의 정수 값이 입력되어야 합니다.");
        } 
        return Integer.parseInt(token);
    }

}
