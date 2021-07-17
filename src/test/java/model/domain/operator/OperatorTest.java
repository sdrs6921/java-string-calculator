package model.domain.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
    @DisplayName("유효하지 않은 연산자는 예외를 발생시킵니다")
    void validateOperator(String invalidOperator) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.of(invalidOperator))
                .withMessage("유효한 연산자가 아닙니다");
    }
}
