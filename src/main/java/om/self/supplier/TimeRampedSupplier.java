package om.self.supplier;

import java.math.BigDecimal;
import java.util.function.Supplier;

public class TimeRampedSupplier extends SimpleRampedSupplier{
    private BigDecimal rampPerMs;
    private Long lastUpdateTime = System.currentTimeMillis();

    public TimeRampedSupplier(Supplier<BigDecimal> baseSupplier) {
        super(baseSupplier);
    }

    public TimeRampedSupplier(Supplier<BigDecimal> baseSupplier, BigDecimal rampPerMs) {
        super(baseSupplier);
        this.rampPerMs = rampPerMs;
    }

    public TimeRampedSupplier(Supplier<BigDecimal> baseSupplier, BigDecimal rampPerMs, BigDecimal currentVal) {
        super(baseSupplier, null, currentVal);
        this.rampPerMs = rampPerMs;
    }

    public BigDecimal getRampPerMs() {
        return rampPerMs;
    }

    public void setRampPerMs(BigDecimal rampPerMs) {
        this.rampPerMs = rampPerMs;
    }

    @Override
    public BigDecimal apply(BigDecimal baseInput) {
        setRamp(new BigDecimal(System.currentTimeMillis() - lastUpdateTime).multiply(rampPerMs));
        lastUpdateTime = System.currentTimeMillis();
        return super.apply(baseInput);
    }
}
