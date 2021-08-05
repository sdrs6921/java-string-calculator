package model.domain;

import model.domain.operator.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.api.Assertions.assertAll;

class ExpressionTest {

    private static final String[] TOKENS = "1 + 2".split(" ");
    private Expression expression;

    @BeforeEach
    void setUp() {
        expression = new Expression(TOKENS);
    }

    @Test
    @DisplayName("길이가 3이하이거나 짝수가 아닌 토큰을 입력하면 예외를 발생시킨다")
    void create_throw_exception_with_invalid_token() {
        String[] token = "1 + ".split("");

        assertThatIllegalStateException().isThrownBy(() -> new Expression(token))
                .withMessage("유효하지 않은 수식입니다");
    }

    @Test
    @DisplayName("다음 연산자의 존재 여부를 반환한다")
    void hasNextOperator() {
        boolean hasNextOperator = expression.hasNextOperator();
        expression.nextOperator();
        boolean doesNotHasNext = expression.hasNextOperator();

        assertAll(
                () -> assertThat(hasNextOperator).isTrue(),
                () -> assertThat(doesNotHasNext).isFalse()
        );
    }

    @Test
    @DisplayName("다음 피연산자의 존재 여부를 반환한다")
    void hasNextOperand() {
        boolean hasNextOperand = expression.hasNextOperand();
        expression.nextOperand();
        expression.nextOperand();
        boolean doesNotHasNextOperand = expression.hasNextOperand();

        assertAll(
                () -> assertThat(hasNextOperand).isTrue(),
                () -> assertThat(doesNotHasNextOperand).isFalse()
        );
    }

    @Test
    @DisplayName("다음 연산자를 반환한다")
    void nextOperator() {
        Operator nextOperator = expression.nextOperator();

        assertThat(nextOperator).isEqualTo(Operator.PLUS);
    }

    @Test
    @DisplayName("다음 연산자를 반환한다")
    void nextOperand() {
        int expected = 1;
        int nextOperand = expression.nextOperand();

        assertThat(nextOperand).isEqualTo(expected);
    }
}
