package model.domain.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SubtractionTest {

    @ParameterizedTest
    @CsvSource(value = {"+, false", "-, true", "*, false", "/, false"})
    @DisplayName("피연산자를 입력받아 빼기 연산자면 참을 반환하고 아니면 거짓을 반환한다")
    void hasOperator(String symbol, boolean expect) {
        Operation operation = new Subtraction();

        boolean actual = operation.hasOperator(Operator.of(symbol));

        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"4, 2, 2", "7, 3, 4"})
    @DisplayName("두 개의 숫자를 입력 받아 빼기 연산을 수행한 결과를 반환한다")
    void operate(int operand1, int operand2, int expect) {
        Operation operation = new Subtraction();

        int actual = operation.operate(operand1, operand2);

        assertThat(actual).isEqualTo(expect);
    }
}
