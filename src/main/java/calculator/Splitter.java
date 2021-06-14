package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {

    private static final String OR = "|";
    private static final String BASIC_DELIMITER_REGEX = "," + OR + ":";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final int CUSTOM_DELIMITER = 1;
    private static final int TRIMMED_TEXT = 2;

    private String delimitersRegex;
    private String text;

    public Splitter(String text) {
        this.text = text;
        this.delimitersRegex = BASIC_DELIMITER_REGEX;
        updateIfCustomDelimiterExists();
    }

    private void updateIfCustomDelimiterExists() {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if (matcher.find()) {
            delimitersRegex += OR + matcher.group(CUSTOM_DELIMITER);
            text = matcher.group(TRIMMED_TEXT);
        }
    }

    public String[] split() {
        return text.split(delimitersRegex);
    }
}
