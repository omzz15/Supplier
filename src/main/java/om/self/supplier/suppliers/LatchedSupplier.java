package om.self.supplier.suppliers;

import java.util.function.Supplier;

/**
 * @deprecated use {@link om.self.supplier.modifiers.LatchedModifier} with the toSupplier() method
 */
@Deprecated
abstract public class LatchedSupplier implements Supplier<Boolean> {
    protected final EdgeSupplier edge = new EdgeSupplier();
    protected boolean latchValue = false;

    public LatchedSupplier() {
    }

    public LatchedSupplier(boolean latchValue) {
        this.latchValue = latchValue;
    }

    public LatchedSupplier(Supplier<Boolean> baseSupplier, boolean latchValue){
        this.latchValue = latchValue;
        edge.setBase(baseSupplier);
    }

    public void setBase(Supplier<Boolean> baseSupplier){
        edge.setBase(baseSupplier);
    }

    public boolean getLatchValue() {
        return latchValue;
    }

    public void setLatchValue(boolean latchValue) {
        this.latchValue = latchValue;
    }

    public abstract Boolean get();
}
