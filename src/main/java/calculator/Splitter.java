package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    private static final String OR = "|";
    private static final String BASIC_DELIMITER_REGEX = "," + OR + ":";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
    private static final int TRIMMED_TEXT_GROUP_INDEX = 2;

    public static String[] split(String text) {
        String delimitersRegex = BASIC_DELIMITER_REGEX;
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (matcher.find()) {
            delimitersRegex += OR + matcher.group(CUSTOM_DELIMITER_GROUP_INDEX);
            text = matcher.group(TRIMMED_TEXT_GROUP_INDEX);
        }
        return text.split(delimitersRegex);
    }
}
