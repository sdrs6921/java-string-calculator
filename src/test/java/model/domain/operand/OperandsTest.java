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
    private static final String OPERAND_TOKEN = "2";
    private static final int OPERAND = Integer.parseInt(OPERAND_TOKEN);

    private Operands operands;

    @BeforeEach
    void setUp() {
        List<Operand> singleOperands = Collections.singletonList(Operand.valueOf(OPERAND_TOKEN));
        operands = new Operands(singleOperands);
    }

    @Test
    @DisplayName("Operands의 index를 받아 Operand의 값을 리턴합니댜")
    void getElement() {
        int operand = operands.indexOf(0);

        assertThat(operand).isEqualTo(OPERAND);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "1"})
    @DisplayName("operands의 index가 범위를 벗어날 경우 예외를 발생시킨다")
    void getElement_throw_exception_with_index_out_of_range(int outOfRangeIndex) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> operands.indexOf(outOfRangeIndex))
                .withMessage("범위를 초과한 index 입니다");
    }

    @Test
    @DisplayName("Operand의 크기를 반환한다")
    void getOperandsSize() {
        int operandsSize = operands.size();

        assertThat(operandsSize).isEqualTo(1);
    }

    @Test
    @DisplayName("Operand의 첫번째 원소를 반환한다")
    void getFirstElement() {
        int firstOperand = operands.firstElement();

        assertThat(firstOperand).isEqualTo(OPERAND);
    }
}
