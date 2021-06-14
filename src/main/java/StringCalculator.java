import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String NUMBER = "^[0-9]*$";
    private static final String DELIMITER = "[,:]";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) return 0;

        String[] tokens = input.split(DELIMITER);
        Matcher m = CUSTOM_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }

        return sum(tokens);
    }

    private static int sum(String[] tokens) {
        int sum = 0;
        for (String t : tokens) {
            sum += parseInt(t);
        }
        return sum;
    }

    private static int parseInt(String token) {
        if (!Pattern.matches(NUMBER, token)) {
            throw new RuntimeException("입력값이 잘못되었습니다.");
        } 
        return Integer.parseInt(token);
    }

}
