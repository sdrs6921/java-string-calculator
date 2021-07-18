package model.domain.operand;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperandsTest {

    private Operands operands;

    @BeforeEach
    void setUp() {
        List<Operand> singleOperands = Collections.singletonList(Operand.valueOf("2"));
        operands = new Operands(singleOperands);
    }

    @Test
    @DisplayName("Operands의 index를 받아 Operand의 값을 리턴합니댜")
    void getElement() {
        int element = operands.getElement(0);

        assertThat(element).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "1"})
    @DisplayName("operands의 index가 범위를 벗어날 경우 예외를 발생시킵니다")
    void getElement_throw_exception_with_index_out_of_range(int outOfRangeIndex) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> operands.getElement(outOfRangeIndex))
                .withMessage("범위를 초과한 index 입니다");
    }

    @Test
    @DisplayName("Operand의 크기를 리턴합니다")
    void getOperandsSize() {
        int operandsSize = operands.getOperandsSize();

        assertThat(operandsSize).isEqualTo(1);
    }
}
