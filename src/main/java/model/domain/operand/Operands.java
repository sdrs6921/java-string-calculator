package model.domain.operand;

import java.util.Objects;
import java.util.Queue;

public class Operands {
    private final Queue<Operand> values;

    public Operands(Queue<Operand> values) {
        this.values = values;
    }

    public boolean hasNext() {
        return !values.isEmpty();
    }

    public int next() {
        if (Objects.isNull(values) || values.isEmpty()) {
            throw new IllegalStateException("연산자가 없습니다");
        }

        return values.poll().value();
    }
}
