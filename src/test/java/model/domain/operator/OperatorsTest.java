package model.domain.operator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorsTest {
    private Operators operators;

    @BeforeEach
    void setUp() {
        List<Operator> singleOperators = Collections.singletonList(Operator.of("+"));
        operators = new Operators(singleOperators);
    }

    @Test
    @DisplayName("Operator의 index를 받아 원소를 반환한다")
    void getElement() {
        String operator = operators.getElement(0);

        assertThat(operator).isEqualTo("+");
    }

    @Test
    @DisplayName("")
    void getOperatorsSize() {
        int operatorsSize = operators.getOperatorsSize();

        assertThat(operatorsSize).isEqualTo(1);
    }
}
