package om.self.supplier;

import static om.self.supplier.Utils.toBigDecimal;

import java.math.BigDecimal;
import java.util.function.Supplier;

public class DeadZoneSupplier<T extends Number> extends ModifiableSupplier<T> {
    private Supplier<T> deadZoneSupplier;
    private T deadZoneMin;
    private T deadZoneMax;

    public DeadZoneSupplier() {
    }

    public DeadZoneSupplier(Supplier<T> baseSupplier) {
        super(baseSupplier);
    }

    public DeadZoneSupplier(Supplier<T> baseSupplier, Supplier<T> deadZoneSupplier) {
        super(baseSupplier);
        this.deadZoneSupplier = deadZoneSupplier;
    }

    public DeadZoneSupplier(Supplier<T> baseSupplier, T deadZoneMin, T deadZoneMax) {
        super(baseSupplier);
        this.deadZoneMin = deadZoneMin;
        this.deadZoneMax = deadZoneMax;
    }

    public DeadZoneSupplier(Supplier<T> baseSupplier, Supplier<T> deadZoneSupplier, T deadZoneMin, T deadZoneMax) {
        super(baseSupplier);
        this.deadZoneSupplier = deadZoneSupplier;
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
    public T modify(T baseInput) {
        BigDecimal convertedBase = toBigDecimal(baseInput.toString());
        BigDecimal convertedMin = toBigDecimal(deadZoneMin.toString());
        BigDecimal convertedMax = toBigDecimal(deadZoneMax.toString());

        if(convertedBase.compareTo(convertedMin) < 0 || convertedBase.compareTo(convertedMax) > 0) return baseInput;
        return deadZoneSupplier.get();
    }
}
