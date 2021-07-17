package model.domain.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class OperatorTest {

    @Test
    @DisplayName("+, -, *, / 연산지의 기호를 반환한다")
    void symbol() {
        assertAll(
                () -> assertThat(Operator.PLUS.symbol()).isEqualTo("+"),
                () -> assertThat(Operator.MINUS.symbol()).isEqualTo("-"),
                () -> assertThat(Operator.TIMES.symbol()).isEqualTo("*"),
                () -> assertThat(Operator.DIVIDED_BY.symbol()).isEqualTo("/")
        );
    }
}
