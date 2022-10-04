package om.self.supplier.modifiers;

import om.self.supplier.Utils;

public class TimeRampedModifier<T extends Number> extends SimpleRampedModifier<T> {
    private T rampPerMs;
    private Long lastUpdateTime = System.currentTimeMillis();

    public TimeRampedModifier(T rampPerMs) {
        this.rampPerMs = rampPerMs;
    }

    public TimeRampedModifier(T rampPerMs, T currentVal) {
        super(null, currentVal);
        this.rampPerMs = rampPerMs;
    }

    public T getRampPerMs() {
        return rampPerMs;
    }

    public void setRampPerMs(T rampPerMs) {
        this.rampPerMs = rampPerMs;
    }

    @Override
    public T apply(T baseInput) {
        setRamp(Utils.convertNumber ((System.currentTimeMillis() - lastUpdateTime) * rampPerMs.doubleValue(), baseInput));
        lastUpdateTime = System.currentTimeMillis();
        return super.apply(baseInput);
    }
}
