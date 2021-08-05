package model.domain.operation;

import model.domain.operator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static model.domain.operation.Operations.findOperation;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OperationsTest {

    @ParameterizedTest
    @MethodSource("operationProvider")
    @DisplayName("피연산자를 입력받아 피연산자에 해당하는 연산을 반환한다")
    void find(Operator operator, Class<Operation> expect) {
        Operation operation = findOperation(operator);

        assertThat(operation.getClass()).isEqualTo(expect);
    }

    static Stream<Arguments> operationProvider() {
        return Stream.of(
                arguments(Operator.PLUS, Addition.class),
                arguments(Operator.MINUS, Subtraction.class),
                arguments(Operator.TIMES, Multiplication.class),
                arguments(Operator.DIVIDED_BY, Division.class)
        );
    }
}
