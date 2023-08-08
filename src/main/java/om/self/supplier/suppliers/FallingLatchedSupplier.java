package om.self.supplier.suppliers;

/**
 * A supplier that will latch (switch state) on a falling edge
 * @deprecated use {@link om.self.supplier.modifiers.LatchedModifier} with the toSupplier() method
 */
@Deprecated
public class FallingLatchedSupplier extends LatchedSupplier{
    @Override
    public Boolean get() {
        if(edge.isFallingEdge()) latchValue = !latchValue;
        return latchValue;
    }
}