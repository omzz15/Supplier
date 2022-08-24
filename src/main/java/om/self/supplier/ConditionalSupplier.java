package om.self.supplier;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConditionalSupplier<T> extends ModifiableSupplier<T>{
    Supplier<Boolean> condition;
    Function<T, T> modification;

    public ConditionalSupplier() {
    }

    public ConditionalSupplier(Supplier<T> baseSupplier) {
        super(baseSupplier);
    }

    public ConditionalSupplier(Supplier<T> baseSupplier, Supplier<Boolean> condition, Function<T, T> modification) {
        super(baseSupplier);
        this.condition = condition;
        this.modification = modification;
    }

    public Supplier<Boolean> getCondition() {
        return condition;
    }

    public void setCondition(Supplier<Boolean> condition) {
        this.condition = condition;
    }

    public Function<T, T> getModification() {
        return modification;
    }

    public void setModification(Function<T, T> modification) {
        this.modification = modification;
    }

    @Override
    public T modify(T baseInput) {
        return condition.get() ? modification.apply(baseInput) : baseInput;
    }
}
