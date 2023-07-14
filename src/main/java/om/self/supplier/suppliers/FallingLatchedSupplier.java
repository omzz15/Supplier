package om.self.supplier.suppliers;

@Deprecated
public class FallingLatchedSupplier extends LatchedSupplier{
    @Override
    public Boolean get() {
        edge.get();
        if(edge.isFallingEdge()) latchValue = !latchValue;
        return latchValue;
    }
}