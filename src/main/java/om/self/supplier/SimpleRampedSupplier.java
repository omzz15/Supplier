package om.self.supplier;

import java.util.function.Supplier;

public class SimpleRampedSupplier<T extends Number> extends ModifiableSupplier<T> {
    private T ramp;
    private T currentVal;

    public SimpleRampedSupplier() {
    }

    public SimpleRampedSupplier(Supplier<T> baseSupplier) {
        this.baseSupplier = baseSupplier;
    }

    public SimpleRampedSupplier(Supplier<T> baseSupplier, T ramp) {
        this.baseSupplier = baseSupplier;
        this.ramp = ramp;
    }

    public Supplier<T> getBaseSupplier() {
        return baseSupplier;
    }

    public void setBaseSupplier(Supplier<T> baseSupplier) {
        this.baseSupplier = baseSupplier;
    }

    public T getRamp() {
        return ramp;
    }

    public void setRamp(T ramp) {
        this.ramp = ramp;
    }

    @Override
    public T modify(T baseInput) {
        return baseSupplier.get();
    }
}
