package om.self.supplier;

import java.util.function.Function;
import java.util.function.Supplier;

public class DeadZoneSupplier<T extends Comparable<T>> extends ModifiableSupplierImpl<T>{
    Function<T, T> deadZoneFunction;
    private T deadZoneMin;
    private T deadZoneMax;

    public DeadZoneSupplier() {
    }

    public DeadZoneSupplier(Supplier<T> baseSupplier) {
        super(baseSupplier);
    }

    public DeadZoneSupplier(Supplier<T> baseSupplier, Function<T, T> deadZoneFunction) {
        super(baseSupplier);
        this.deadZoneFunction = deadZoneFunction;
    }

    public DeadZoneSupplier(Supplier<T> baseSupplier, T deadZoneMin, T deadZoneMax) {
        super(baseSupplier);
        this.deadZoneMin = deadZoneMin;
        this.deadZoneMax = deadZoneMax;
    }

    public DeadZoneSupplier(Supplier<T> baseSupplier, Function<T, T> deadZoneFunction, T deadZoneMin, T deadZoneMax) {
        super(baseSupplier);
        this.deadZoneFunction = deadZoneFunction;
        this.deadZoneMin = deadZoneMin;
        this.deadZoneMax = deadZoneMax;
    }

    public T getDeadZoneMin() {
        return deadZoneMin;
    }

    public void setDeadZoneMin(T deadZoneMin) {
        this.deadZoneMin = deadZoneMin;
    }

    public T getDeadZoneMax() {
        return deadZoneMax;
    }

    public void setDeadZoneMax(T deadZoneMax) {
        this.deadZoneMax = deadZoneMax;
    }

    @Override
    public T apply(T baseInput) {
        if(baseInput.compareTo(deadZoneMin) < 0 || baseInput.compareTo(deadZoneMax) > 0) return baseInput;
        return deadZoneFunction.apply(baseInput);
    }
}
