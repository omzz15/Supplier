package om.self.supplier.suppliers;

/**
 * @deprecated use {@link om.self.supplier.modifiers.LatchedModifier} with the toSupplier() method
 */
@Deprecated
public class RisingLatchedSupplier extends LatchedSupplier{
    @Override
    public Boolean get() {
        edge.get();
        if(edge.isRisingEdge()) latchValue = !latchValue;
        return latchValue;
    }
}
