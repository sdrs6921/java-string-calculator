package model.domain.operator;

@FunctionalInterface
public interface Operation {
    int operate(int x, int y);
}
