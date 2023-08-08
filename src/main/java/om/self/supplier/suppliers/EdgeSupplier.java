package om.self.supplier.suppliers;

import java.util.function.Supplier;

/**
 * A supplier that will monitor the output from the base supplier and see if there is a rising or falling edge.
 * It can also be used to make rising and falling edge suppliers<br>
 * Note:
 * This is an older implementation
 * that can probably be replaced by {@link om.self.supplier.modifiers.EdgeModifier}
 * unless you need the rising or falling edge suppliers
 */
public class EdgeSupplier implements Supplier<Boolean> {
    /**
     * The base supplier to check edges on
     */
    private Supplier<Boolean> base;
    /**
     * Stores the last value from the base supplier when {@link EdgeSupplier#get()} is called
     */
    private boolean lastVal;

    /**
     * Recommended constructor that sets the base supplier
     * @param base the base supplier to check edges on
     */
    public EdgeSupplier(Supplier<Boolean> base) {
        this.base = base;
    }

    /**
     * default constructor <br>
     * IMPORTANT: you must set the base supplier before using this supplier
     */
    public EdgeSupplier() {
    }

    /**
     * returns the base supplier
     * @return {@link EdgeSupplier#base}
     */
    public Supplier<Boolean> getBase() {
        return base;
    }

    /**
     * sets the base supplier
     * @param base the base supplier to check edges on
     */
    public void setBase(Supplier<Boolean> base) {
        this.base = base;
    }

    /**
     * Grabs the value from the base supplier and stores it. <br>
     * Note:
     * you should probably use {@link EdgeSupplier#isRisingEdge()} or {@link EdgeSupplier#isFallingEdge()} instead of this
     * because those methods automatically call this method.
     * @return the value from the base supplier
     */
    @Override
    public Boolean get() {
        lastVal = base.get();
        return lastVal;
    }

    /**
     * checks if there was a rising edge since the last time {@link EdgeSupplier#get()} was called <br>
     * Note: this method calls {@link EdgeSupplier#get()} so you don't need to call it before this
     * @return if a rising edge was detected
     */
    public boolean isRisingEdge(){
        boolean lastVal = this.lastVal;
        get();
        return !lastVal && this.lastVal;
    }

    /**
     * checks if there was a falling edge since the last time {@link EdgeSupplier#get()} was called <br>
     * Note: this method calls {@link EdgeSupplier#get()} so you don't need to call it before this
     * @return if a falling edge was detected
     */
    public boolean isFallingEdge(){
        boolean lastVal = this.lastVal;
        get();
        return lastVal && !this.lastVal;
    }

    /**
     * returns a supplier that will check if there was a rising edge since the last time {@link EdgeSupplier#get()} was called <br>
     * Note: this method calls {@link EdgeSupplier#get()} so you don't need to call it before this
     * @return a supplier that will return true if a rising edge was detected
     */
    public Supplier<Boolean> getRisingEdgeSupplier(){
        return this::isRisingEdge;
    }

    /**
     * returns a supplier that will check if there was a falling edge since the last time {@link EdgeSupplier#get()} was called <br>
     * Note: this method calls {@link EdgeSupplier#get()} so you don't need to call it before this
     * @return a supplier that will return true if a falling edge was detected
     */
    public Supplier<Boolean> getFallingEdgeSupplier(){
        return this::isFallingEdge;
    }
}
