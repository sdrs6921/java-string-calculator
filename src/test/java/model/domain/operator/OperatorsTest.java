package model.domain.operator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class OperatorsTest {
    private Operators operators;

    @BeforeEach
    void setUp() {
        List<Operator> singleOperators = Collections.singletonList(Operator.of("+"));
        operators = new Operators(singleOperators);
    }

    @Test
    @DisplayName("Operator의 index를 받아 원소를 반환한다")
    void indexOf() {
        String operator = operators.indexOf(0);

        assertThat(operator).isEqualTo("+");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "1"})
    @DisplayName("operator의 index가 범위를 벗어날 경우 예외를 발생시킨다")
    void indexOf_throw_exception_with_index_out_of_range(int outOfRangeIndex) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> operators.indexOf(outOfRangeIndex))
                .withMessage("범위를 초과한 index 입니다");
    }

    @Test
    @DisplayName("operators의 크기를 반환한다.")
    void getOperatorsSize() {
        int operatorsSize = operators.size();

        assertThat(operatorsSize).isEqualTo(1);
    }
}
