package om.self.supplier.suppliers;

import java.util.function.Supplier;

/**
 * @deprecated use {@link om.self.supplier.modifiers.EdgeModifier} with the toSupplier() method
 */
@Deprecated
public class EdgeSupplier implements Supplier<Boolean> {
    private Supplier<Boolean> base;
    private boolean lastVal;

    public EdgeSupplier(Supplier<Boolean> base) {
        this.base = base;
    }

    public EdgeSupplier() {
    }

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
        boolean lastVal = this.lastVal;
        get();
        return !lastVal && this.lastVal;
    }

    public boolean isFallingEdge(){
        boolean lastVal = this.lastVal;
        get();
        return lastVal && !this.lastVal;
    }

    public Supplier<Boolean> getRisingEdgeSupplier(){
        return this::isRisingEdge;
    }
    public Supplier<Boolean> getFallingEdgeSupplier(){
        return this::isFallingEdge;
    }
}
