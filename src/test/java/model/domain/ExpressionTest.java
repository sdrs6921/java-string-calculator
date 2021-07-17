package model.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class ExpressionTest {

    private Expression expression;

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2", "1 + 2 + 3", "1 + 2 - 3 * 4"})
    @DisplayName("수식을 입력받아 값을 초기화한다")
    void create(String value) {
        Expression expression = new Expression(value.split(" "));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 +", "1", "1 + 2 + 3 +"})
    @DisplayName("잘못된 수식을 입력받으면 예외를 발생시킨다")
    void create_throw_exception_with_invalid_expression(String invalidExpression) {
        assertThatIllegalStateException()
                .isThrownBy(() -> new Expression(invalidExpression.split(" ")))
                .withMessage("유효하지 않은 수식입니다");
    }
}
