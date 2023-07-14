package om.self.supplier.suppliers;

@Deprecated
public class RisingLatchedSupplier extends LatchedSupplier{
    @Override
    public Boolean get() {
        edge.get();
        if(edge.isRisingEdge()) latchValue = !latchValue;
        return latchValue;
    }
}
