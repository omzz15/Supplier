package om.self.supplier.modifiers;

import om.self.supplier.Suppliable;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConditionalModifier<T> implements Suppliable<T> {
    Supplier<Boolean> condition;
    Function<T, T> modification;

    public ConditionalModifier() {
    }

    public ConditionalModifier(Supplier<Boolean> condition, Function<T, T> modification) {
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
    public T apply(T baseInput) {
        return condition.get() ? modification.apply(baseInput) : baseInput;
    }
}
