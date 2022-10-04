package om.self.supplier;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModifierStack<T> implements Suppliable<T> {
    private LinkedList<Function<T, T>> stack = new LinkedList<>();

    public ModifierStack() {
    }

    public ModifierStack(LinkedList<Function<T, T>> stack) {
        this.stack = stack;
    }

    @SafeVarargs
    public ModifierStack(Function<T, T>... functions) {
        addToStack(functions);
    }

    public LinkedList<Function<T, T>> getStack() {
        return stack;
    }

    public void setStack(LinkedList<Function<T, T>> stack) {
        this.stack = stack;
    }

    public void addToStack(Function<T, T> function) {
        stack.add(function);
    }

    public void addToStack(Function<T, T>... functions) {
        stack.addAll(Arrays.asList(functions));
    }

    @Override
    public T apply(T baseInput) {
        for (Function<T, T> func : stack) {
            baseInput = func.apply(baseInput);
        }
        return baseInput;
    }
}
