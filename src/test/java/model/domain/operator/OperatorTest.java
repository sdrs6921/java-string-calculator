package model.domain.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class OperatorTest {

    @Test
    @DisplayName("+, -, *, / 연산지의 기호를 반환한다")
    void symbol() {
        assertAll(
                () -> assertThat(Operator.of("+")).isEqualTo(Operator.PLUS),
                () -> assertThat(Operator.of("-")).isEqualTo(Operator.MINUS),
                () -> assertThat(Operator.of("*")).isEqualTo(Operator.TIMES),
                () -> assertThat(Operator.of("/")).isEqualTo(Operator.DIVIDED_BY)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "string", "한글"})
    @DisplayName("유효하지 않은 연산자는 예외를 발생시킨다")
    void validateOperator(String invalidOperator) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.of(invalidOperator))
                .withMessage("유효한 연산자가 아닙니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"3,1", "4,1", "5,2"})
    @DisplayName("두 개의 숫자를 입력 받아 연산을 수행한다")
    void operate(int x, int y) {
        assertAll(
                () -> assertThat(Operator.PLUS.operate(x, y)).isEqualTo(x + y),
                () -> assertThat(Operator.MINUS.operate(x, y)).isEqualTo(x - y),
                () -> assertThat(Operator.TIMES.operate(x, y)).isEqualTo(x * y),
                () -> assertThat(Operator.DIVIDED_BY.operate(x, y)).isEqualTo(x / y)
        );
    }

    @Test
    @DisplayName("0으로 나누게 되면 예외를 발생시킨다")
    void operate_throw_exception_with_divided_by_zero() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.DIVIDED_BY.operate(3, 0))
                .withMessage("0으로 나눌 수 없습니다");
    }
}
