package om.self.supplier.modifiers;

import om.self.supplier.Suppliable;
import java.util.function.Supplier;

public class EdgeModifier implements Suppliable<Boolean> {
    private boolean currVal;
    private boolean lastVal;


    public EdgeModifier(){}

    @Override
    public Boolean apply(Boolean value) {
        lastVal = currVal;
        currVal = value;
        return value;
    }

    public boolean isRisingEdge(){
        return !lastVal && currVal;
    }

    public boolean isFallingEdge(){
        return lastVal && !currVal;
    }
}
