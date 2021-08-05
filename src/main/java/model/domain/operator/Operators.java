package model.domain.operator;

import java.util.Objects;
import java.util.Queue;

public class Operators {
    private final Queue<Operator> values;

    public Operators(Queue<Operator> values) {
        this.values = values;
    }

    public boolean hasNext() {
        return !values.isEmpty();
    }

    public Operator next() {
        if (Objects.isNull(values) || !hasNext()) {
            throw new IllegalStateException("연산자가 없습니다");
        }

        return values.poll();
    }
}
