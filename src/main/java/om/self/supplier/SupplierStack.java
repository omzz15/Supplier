package om.self.supplier;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.Supplier;

public class SupplierStack<T> extends ModifiableSupplierImpl<T> {
    private LinkedList<Function<T, T>> stack = new LinkedList<>();

    public SupplierStack() {
    }

    public SupplierStack(Supplier<T> baseSupplier) {
        super(baseSupplier);
    }

    public SupplierStack(Supplier<T> baseSupplier, LinkedList<Function<T, T>> stack) {
        super(baseSupplier);
        this.stack = stack;
    }

    public SupplierStack(Supplier<T> baseSupplier, Function<T, T>... stackFunctions) {
        super(baseSupplier);
        this.stack.addAll(Arrays.asList(stackFunctions));
    }

    public LinkedList<Function<T, T>> getStack() {
        return stack;
    }

    public void setStack(LinkedList<Function<T, T>> stack) {
        this.stack = stack;
    }

    @Override
    public T apply(T baseInput) {
        for (Function<T, T> func : stack) {
            baseInput = func.apply(baseInput);
        }
        return baseInput;
    }
}
