package model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ExpressionTest {
    private Expression expression;

    @ParameterizedTest
    @CsvSource(value = {"1 + 2, 2, 1", "1 + 2 + 3, 3, 2", "1 + 2 - 3 * 4, 4, 3"})
    @DisplayName("수식을 입력받아 값을 초기화한다")
    void create(String value, int operandSize, int operatorSize) {
        expression = new Expression(value.split(" "));

        assertAll(
                () -> assertThat(expression.operandSize()).isEqualTo(operandSize),
                () -> assertThat(expression.operatorSize()).isEqualTo(operatorSize)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 +", "1", "1 + 2 + 3 +"})
    @DisplayName("잘못된 수식을 입력받으면 예외를 발생시킨다")
    void create_throw_exception_with_invalid_expression(String invalidExpression) {
        assertThatIllegalStateException()
                .isThrownBy(() -> new Expression(invalidExpression.split(" ")))
                .withMessage("유효하지 않은 수식입니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2, 1", "2 + 3, 2"})
    @DisplayName("피연산자의 첫번째 값을 반환한다")
    void getFirstElement(String value, int firstElement) {
        expression = new Expression(value.split(" "));

        assertThat(expression.firstOperand()).isEqualTo(firstElement);
    }

    @Test
    @DisplayName("피연산자와 연산자의 index를 입력받아 값을 반환한다")
    void indexOf() {
        String[] values = {"1", "+", "2"};
        expression = new Expression(values);

        assertAll(
                () -> assertThat(expression.operandIndexOf(0)).isEqualTo(1),
                () -> assertThat(expression.operatorIndexOf(0)).isEqualTo("+")
        );
    }
}
