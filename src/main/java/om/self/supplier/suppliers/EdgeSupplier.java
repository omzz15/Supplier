package om.self.supplier.suppliers;

import java.util.function.Supplier;

public class EdgeSupplier implements Supplier<Boolean> {
    private Supplier<Boolean> base;
    private boolean lastVal;

    public Supplier<Boolean> getBase() {
        return base;
    }

    public void setBase(Supplier<Boolean> base) {
        this.base = base;
    }

    @Override
    public Boolean get() {
        lastVal = base.get();
        return lastVal;
    }

    public boolean isRisingEdge(){
        return !lastVal && get();
    }

    public boolean isFallingEdge(){
        return lastVal && !get();
    }
}
