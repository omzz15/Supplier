package om.self.supplier;

import java.math.BigDecimal;
import java.util.function.Supplier;

public class SimpleRampedSupplier extends ModifiableSupplierImpl<BigDecimal> {
    private BigDecimal ramp;
    private BigDecimal currentVal = new BigDecimal(0);

    public SimpleRampedSupplier() {
    }

    public SimpleRampedSupplier(Supplier<BigDecimal> baseSupplier){
        super(baseSupplier);
    }

    public SimpleRampedSupplier(Supplier<BigDecimal> baseSupplier, BigDecimal ramp) {
        super(baseSupplier);
        this.ramp = ramp;
    }

    public SimpleRampedSupplier(Supplier<BigDecimal> baseSupplier, BigDecimal ramp, BigDecimal currentVal) {
        super(baseSupplier);
        this.ramp = ramp;
        this.currentVal = currentVal;
    }

    public BigDecimal getRamp() {
        return ramp;
    }

    public void setRamp(BigDecimal ramp) {
        this.ramp = ramp;
    }

    public BigDecimal getCurrentVal() {
        return currentVal;
    }

    public void setCurrentVal(BigDecimal currentVal) {
        this.currentVal = currentVal;
    }

    @Override
    public BigDecimal apply(BigDecimal baseInput) {
        int compare = currentVal.compareTo(baseInput);

        if(compare < 0) currentVal = baseInput.min(currentVal.add(ramp));
        if(compare > 0) currentVal = baseInput.max(currentVal.subtract(ramp));

        return currentVal;
    }
}
