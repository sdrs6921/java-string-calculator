package model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("validParameterProvider")
    @DisplayName("Expression을 입력받아 값을 계산하여 반환한다")
    void calculate(String[] token, int answer) {
        Expression expression = new Expression(token);
        Calculator calculator = new Calculator(expression);

        int expect = calculator.calculate();

        assertThat(expect).isEqualTo(answer);
    }

    @Test
    @DisplayName("0으로 나누는 식을 받으면 예외를 발생시킨다")
    void calculate_throw_exception_with_divide_by_zero() {
        String[] invalidToken = {"1", "/", "0"};
        Expression expression = new Expression(invalidToken);
        Calculator calculator = new Calculator(expression);

        assertThatIllegalArgumentException()
                .isThrownBy(calculator::calculate)
                .withMessage("0으로 나눌 수 없습니다");
    }

    static Stream<Arguments> validParameterProvider() {
        return Stream.of(
                Arguments.of(new String[]{"4", "+", "5"}, 9), Arguments.of(new String[]{"2", "-", "1"}, 1),
                Arguments.of(new String[]{"1", "*", "2"}, 2), Arguments.of(new String[]{"2", "/", "1"}, 2));
    }
}
