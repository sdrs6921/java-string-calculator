package model.domain.operand;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OperandsTest {
    private Operands operands;

    @ParameterizedTest
    @MethodSource("hasNextParameterProvider")
    @DisplayName("피연산자가 존재하면 참, 존재하지 않으면 거짓을 반환한다")
    void hasNext(Queue<Operand> values, boolean expect) {
        Operands operands = new Operands(values);

        boolean actual = operands.hasNext();

        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "3,3"})
    @DisplayName("피연산자의 다음 값을 반환한다")
    void next(String value, int expect) {
        Queue<Operand> values
                = new LinkedList<>(Collections.singletonList(Operand.valueOf(value)));
        Operands operands = new Operands(values);

        assertThat(operands.next()).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("nextExceptionParameterProvider")
    @DisplayName("피연산자의 다음 값 요청시 객체가 존재하지 않거나 값이 없는 경우 예외를 발생시킨다")
    void next_throw_exception_with_null_or_empty_operands(Queue<Operand> values) {
        Operands operands = new Operands(values);

        assertThatIllegalStateException().isThrownBy(operands::next)
                .withMessage("연산자가 없습니다");
    }

    static Stream<Arguments> hasNextParameterProvider() {
        return Stream.of(
                arguments(new LinkedList<>(Collections.singletonList(Operand.valueOf("1"))), true),
                arguments(new LinkedList<>(), false)
        );
    }

    static Stream<Queue<Operand>> nextExceptionParameterProvider() {
        return Stream.of(null, new LinkedList<>());
    }
}
