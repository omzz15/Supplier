package om.self.supplier.suppliers;

import java.util.function.Supplier;

/**
 * The framework for a supplier that will latch (switch state) on an edge. This is implemented by {@link RisingLatchedSupplier} and {@link FallingLatchedSupplier}
 * @deprecated use {@link om.self.supplier.modifiers.LatchedModifier} with the toSupplier() method
 */
@Deprecated
abstract public class LatchedSupplier implements Supplier<Boolean> {
    /**
     * used to detect edges
     */
    protected final EdgeSupplier edge = new EdgeSupplier();
    /**
     * the current state of the latch (output of this supplier)
     */
    protected boolean latchValue = false;

    /**
     * default constructor <br>
     * IMPORTANT: you must set the base supplier before using this supplier
     */
    public LatchedSupplier() {
    }

    /**
     * Constructor that sets the latch value (the current state of the latch)
     * @param latchValue the current state of the latch (the output of this supplier)
     */
    public LatchedSupplier(boolean latchValue) {
        this.latchValue = latchValue;
    }

    /**
     * Recommended constructor that sets the base supplier and the latch value
     * @param baseSupplier the base supplier to check edges on
     * @param latchValue the current state of the latch (the output of this supplier)
     */
    public LatchedSupplier(Supplier<Boolean> baseSupplier, boolean latchValue){
        this.latchValue = latchValue;
        edge.setBase(baseSupplier);
    }

    /**
     * sets the base supplier
     * @param baseSupplier the base supplier to check edges on
     */
    public void setBase(Supplier<Boolean> baseSupplier){
        edge.setBase(baseSupplier);
    }

    /**
     * returns the latch value (the current state of the latch)
     * @return {@link LatchedSupplier#latchValue}
     */
    public boolean getLatchValue() {
        return latchValue;
    }

    /**
     * sets the latch value (the current state of the latch)
     * @param latchValue the current state of the latch (the output of this supplier)
     */
    public void setLatchValue(boolean latchValue) {
        this.latchValue = latchValue;
    }

    public abstract Boolean get();
}
