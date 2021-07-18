package model.domain.operator;

import java.util.List;

public class Operators {
    private List<Operator> operators;

    public Operators(List<Operator> operators) {
        this.operators = operators;
    }

    public String getElement(int index) {
        return operators.get(index).symbol();
    }

    public int getOperatorsSize() {
        return operators.size();
    }
}
