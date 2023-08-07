package om.self.supplier.modifiers;

/**
 * An extension of {@link EdgeExModifier} that will convert the input to a latched output based on either a rising or falling edge.
 */
public class LatchedModifier extends EdgeExModifier{
    /**
     * The latched output value returned when {@link #apply(Boolean)} is run.
     */
    private boolean latchValue = false;

    /**
     * Default constructor that sets the {@link #latchValue} to false and the latch type to {@link LatchType#RISING_EDGE}
     */
    public LatchedModifier() {
        setLatchType(LatchType.RISING_EDGE);
    }

    /**
     * Constructor that sets the {@link #latchValue} to the given value and the latch type to {@link LatchType#RISING_EDGE}
     * @param latchValue the value to set {@link #latchValue} to
     */
    public LatchedModifier(boolean latchValue) {
        this.latchValue = latchValue;
        setLatchType(LatchType.RISING_EDGE);
    }

    /**
     * Constructor that sets the {@link #latchValue} to false and the latch type to the given type
     * @param type the LatchType of this latch modifier
     */
    public LatchedModifier(LatchType type) {
        setLatchType(type);
    }

    /**
     * returns the current value of the latch (what will be returned when {@link #apply(Boolean)} is run)
     * @return {@link #latchValue}
     */
    public boolean getLatchValue() {
        return latchValue;
    }

    /**
     * sets the {@link #latchValue} to the given value
     * @param latchValue the value to set {@link #latchValue} to (what is returned when {@link #apply(Boolean)} is run)
     */
    public void setLatchValue(boolean latchValue) {
        this.latchValue = latchValue;
    }

    /**
     * Mostly just a helper method for toggling {@link #latchValue} when an edge is detected, but you can just use it to invert the {@link #latchValue}
     */
    public void invertLatchValue(){
        latchValue = !latchValue;
    }

    /**
     * Changes which edge the latch will change on.
     * @param type the {@link LatchType} to set the latch to
     */
    public void setLatchType(LatchType type){
        switch (type) {
            case RISING_EDGE:
                setOnFall(() -> {
                });
                setOnRise(this::invertLatchValue);
                break;
            case FALLING_EDGE:
                setOnRise(() -> {
                });
                setOnFall(this::invertLatchValue);
                break;
        }
    }

    /**
     * Checks if the input makes a rising or falling edge and changes the {@link #latchValue} accordingly.
     * @param value the input value to check for edges
     * @return {@link #latchValue}
     */
    @Override
    public Boolean apply(Boolean value){
        super.apply(value);
        return latchValue;
    }

    /**
     * This represents the type of edge that the latched modifier will change on.
     */
    public enum LatchType{
        /**
         * This will cause the value to change on a rising edge.
         */
        RISING_EDGE,
        /**
         * This will cause the value to change on a falling edge.
         */
        FALLING_EDGE,
    }
}