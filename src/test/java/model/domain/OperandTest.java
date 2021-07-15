package model.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperandTest {

    private static final String OPERAND_VALUE = "1";

    private Operand operand;

    @BeforeEach
    void setUp() {
        operand = Operand.valueOf(OPERAND_VALUE);
    }

    @Test
    @DisplayName("피연산자를 초기화하면 값을 초기화 한다.")
    void create() {
        int expect = operand.value();
        int actual = Integer.parseInt(OPERAND_VALUE);

        assertThat(expect).isEqualTo(actual);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"string", "+", "한글", "1.0"})
    @DisplayName("피연산자에 정수가 아닌 문자열 들어오게 되면 예외를 발생시킨다.")
    void create_throw_error_with_not_int_value(String invalidOperand) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operand.valueOf(invalidOperand))
                .withMessage("올바른 피연산자가 아닙니다");
    }
}
