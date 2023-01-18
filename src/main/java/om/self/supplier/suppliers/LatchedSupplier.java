package om.self.supplier.suppliers;

import java.util.function.Supplier;

public class LatchedSupplier implements Supplier<Boolean> {
    public final EdgeSupplier edge = new EdgeSupplier();
    private boolean latchValue = false;

    public LatchedSupplier() {
    }

    public LatchedSupplier(boolean latchValue) {
        this.latchValue = latchValue;
    }

    public LatchedSupplier(Supplier<Boolean> baseSupplier, boolean latchValue){
        this.latchValue = latchValue;
        edge.setBase(baseSupplier);
    }

    public boolean getLatchValue() {
        return latchValue;
    }

    public void setLatchValue(boolean latchValue) {
        this.latchValue = latchValue;
    }

    public Boolean get() {
        if(edge.isRisingEdge()) latchValue = !latchValue;
        return latchValue;
    }
}
