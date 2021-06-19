import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final String POSITIVE_NUMBER_REX = "^[0-9]*$";
    private static final String DELIMITER = "[,:]";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (StringUtils.isEmpty(input)) {
            return 0;
        }
        return sum(splitTokens(input));
    }

    private static List<String> splitTokens(String input) {
        List<String> tokens = Arrays.stream(input.split(DELIMITER)).collect(Collectors.toList());

        Matcher m = CUSTOM_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] customTokens = m.group(2).split(customDelimiter);
            tokens.clear();
            Arrays.stream(customTokens)
                    .forEach(t -> Arrays.stream(t.split(DELIMITER))
                            .forEach(token -> tokens.add(token)));
        }
        return tokens;
    }

    private static int sum(List<String> tokens) {
        return tokens.stream().mapToInt(t -> parsePositiveNumber(t)).sum();
    }

    private static int parsePositiveNumber(String token) {
        if (!Pattern.matches(POSITIVE_NUMBER_REX, token)) {
            throw new RuntimeException("양의 정수 값이 입력되어야 합니다.");
        }
        return Integer.parseInt(token);
    }

}
