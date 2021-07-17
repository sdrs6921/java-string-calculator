package model.domain.operand;

import java.util.Objects;
import java.util.regex.Pattern;

public class Operand {

    private final int value;
    private static final String OPERAND_PATTERN_REGEX = "^[0-9]+$";
    private static final Pattern OPERAND_PATTERN = Pattern.compile(OPERAND_PATTERN_REGEX);

    private Operand(String value) {
        if (Objects.isNull(value) || !OPERAND_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("올바른 피연산자가 아닙니다");
        }

        this.value = Integer.parseInt(value);
    }

    public static Operand valueOf(String value) {
        return new Operand(value);
    }

    public int value() {
        return value;
    }
}
