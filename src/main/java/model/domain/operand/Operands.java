package model.domain.operand;

import java.util.List;

public class Operands {
    private static final int FIRST_INDEX = 0;

    private final List<Operand> operands;

    public Operands(List<Operand> operands) {
        this.operands = operands;
    }

    public int getElement(int index) {
        if (isIndexOutOfRange(index)) {
            throw new IllegalArgumentException("범위를 초과한 index 입니다");
        }

        return operands.get(index).value();
    }

    private boolean isIndexOutOfRange(int index) {
        return index < FIRST_INDEX || index >= getOperandsSize();
    }

    public int getOperandsSize() {
        return operands.size();
    }

    public int getFirstElement() {
        return operands.get(FIRST_INDEX).value();
    }
}
