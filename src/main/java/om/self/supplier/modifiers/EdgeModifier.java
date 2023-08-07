package om.self.supplier.modifiers;

import om.self.supplier.core.SingleTypeModifier;

/**
 * A modifier that will track the input and allow you to check if it is a rising or falling edge
 */
public class EdgeModifier implements SingleTypeModifier<Boolean> {
    private boolean currVal;
    private boolean lastVal;

    /**
     * Default constructor
     */
    public EdgeModifier(){}

    /**
     * takes the input value and checks if it is a rising or falling edge
     * @param value the value to check
     * @return the same value
     */
    @Override
    public Boolean apply(Boolean value) {
        lastVal = currVal;
        currVal = value;
        return value;
    }

    /**
     * checks if the last values make a rising edge
     * @return true if the current value is true and the last value is false
     */
    public boolean isRisingEdge(){
        return !lastVal && currVal;
    }

    /**
     * checks if the last values make a falling edge
     * @return true if the current value is false and the last value is true
     */
    public boolean isFallingEdge(){
        return lastVal && !currVal;
    }
}
