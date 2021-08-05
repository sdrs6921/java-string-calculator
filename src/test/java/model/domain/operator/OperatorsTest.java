package model.domain.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OperatorsTest {

    @ParameterizedTest
    @MethodSource("hasNextTestProvider")
    @DisplayName("다음 연산자가 존재하면 참, 존재하지 않으면 거짓을 반환한다")
    void hasNext(Queue<Operator> operatorToken, boolean expect) {
        Operators operators = new Operators(operatorToken);

        boolean hasNext = operators.hasNext();

        assertThat(hasNext).isEqualTo(expect);
    }

    @Test
    @DisplayName("다음 연산자가 존재하면 다음 연산자의 값을 반환한다")
    void next() {
        String symbol = "+";
        Queue<Operator> values = new LinkedList<>(Collections.singletonList(Operator.of(symbol)));
        Operators operators = new Operators(values);

        Operator next = operators.next();

        assertThat(next).isEqualTo(Operator.PLUS);
    }

    @ParameterizedTest
    @MethodSource("nextExceptionTestProvider")
    @DisplayName("다음 연산자가 없거나 객체가 존재하지 않을 경우 예외를 발생시킨다")
    void next_throw_exception_with_null_or_empty_values(Queue<Operator> values) {
        Operators operators = new Operators(values);

        assertThatIllegalStateException().isThrownBy(operators::next)
                .withMessage("연산자가 없습니다");
    }

    static Stream<Arguments> hasNextTestProvider() {
        return Stream.of(
                arguments(new LinkedList<>(Collections.singletonList(Operator.PLUS)), true),
                arguments(new LinkedList<Operator>(), false)
        );
    }

    static Stream<Queue<Operator>> nextExceptionTestProvider() {
        return Stream.of(null, new LinkedList<>());
    }
}
