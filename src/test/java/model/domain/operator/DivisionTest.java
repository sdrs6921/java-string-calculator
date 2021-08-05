package model.domain.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DivisionTest {

    @ParameterizedTest
    @CsvSource(value = {"+, false", "-, false", "*, false", "/, true"})
    @DisplayName("피연산자를 입력받아 나눗셈 연산자면 참을 반환하고 아니면 거짓을 반환한다")
    void hasOperator(String symbol, boolean expect) {
        Operation operation = new Division();

        boolean actual = operation.hasOperator(Operator.of(symbol));

        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"2, 1, 2", "4, 2, 2"})
    @DisplayName("두 개의 숫자를 입력 받아 나눗셈 연산을 수행한 결과를 반환한다")
    void operate(int operand1, int operand2, int expect) {
        Operation operation = new Division();

        int actual = operation.operate(operand1, operand2);

        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("두 개의 숫자 중에서 두 번째 인자로 받은 수가 0이면 예외를 발생시킨다")
    void operate_throws_exception_with_divided_by_zero() {
        Operation operation = new Division();

        assertThatIllegalArgumentException().isThrownBy(() -> operation.operate(2, 0))
                .withMessage("0으로 나눌 수 없음");
    }
}
