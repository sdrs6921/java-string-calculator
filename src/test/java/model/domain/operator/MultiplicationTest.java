package model.domain.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplicationTest {

    @ParameterizedTest
    @CsvSource(value = {"+, false", "-, false", "*, true", "/, false"})
    @DisplayName("피연산자를 입력받아 곱셈 연산자면 참을 반환하고 아니면 거짓을 반환한다")
    void hasOperator(String symbol, boolean expect) {
        Operation operation = new Multiplication();

        boolean actual = operation.hasOperator(Operator.of(symbol));

        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"2, 3, 6", "3, 4, 12"})
    @DisplayName("두 개의 숫자를 입력 받아 곱셈 연산을 수행한 결과를 반환한다")
    void operate(int operand1, int operand2, int expect) {
        Operation operation = new Multiplication();

        int actual = operation.operate(operand1, operand2);

        assertThat(actual).isEqualTo(expect);
    }
}
