package om.self.supplier;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class ModifiableSupplier<T> implements Supplier<T> {
    private Supplier<T> baseSupplier;

    public ModifiableSupplier() {
    }

    public ModifiableSupplier(Supplier<T> baseSupplier) {
        this.baseSupplier = baseSupplier;
    }

    public Supplier<T> getBaseSupplier() {
        return baseSupplier;
    }

    public void setBaseSupplier(Supplier<T> baseSupplier) {
        this.baseSupplier = baseSupplier;
    }

    public abstract T modify(T baseInput);

    @Override
    public T get() {
        return modify(baseSupplier.get());
    }

    public Function<T, T> toFunction(){
        return this::modify;
    }
}
