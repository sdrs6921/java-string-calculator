package model.domain.operand;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperandTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "12,12", "123,123"})
    @DisplayName("피연산자를 초기화하면 값을 초기화 한다.")
    void create(String value, int actual) {
        Operand operand = Operand.valueOf(value);

        assertThat(operand.value()).isEqualTo(actual);
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
