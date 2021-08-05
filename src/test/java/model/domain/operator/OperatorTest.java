package model.domain.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OperatorTest {

    @ParameterizedTest
    @MethodSource("operatorProvider")
    @DisplayName("+, -, *, / 연산지의 기호를 반환한다")
    void symbol(String symbol, Operator expect) {
        Operator actual = Operator.of(symbol);

        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "string", "한글"})
    @DisplayName("유효하지 않은 연산자는 예외를 발생시킨다")
    void validateOperator(String invalidOperator) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.of(invalidOperator))
                .withMessage("유효한 연산자가 아닙니다");
    }

    static Stream<Arguments> operatorProvider() {
        return Stream.of(
                arguments("+", Operator.PLUS),
                arguments("-", Operator.MINUS),
                arguments("*", Operator.TIMES),
                arguments("/", Operator.DIVIDED_BY)
        );
    }
}
