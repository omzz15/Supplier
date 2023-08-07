package om.self.supplier.modifiers;

import om.self.supplier.core.SingleTypeModifier;

/**
 * A simple modifier that ramps the value up or down to the base value (using doubles)
 */
public class SimpleRampedModifier implements SingleTypeModifier<Double> {
    /**
     * The amount to ramp the value by (each time {@link #apply(Double)} is called) to try to reach the base value
     */
    private double ramp;
    /**
     * The current output value of the modifier
     */
    private double currentVal;

    /**
     * Default constructor with a ramp of 0 and a current value of 0 (if the ramp is not changed, the output will always be 0)
     *
     * @see #SimpleRampedModifier(double)
     * @see #SimpleRampedModifier(double, double)
     */
    public SimpleRampedModifier() {
    }

    /**
     * Constructor that takes a ramp and sets the current value to 0
     * @param ramp the amount to ramp the value by to try to reach the base value ({@link #ramp})
     */
    public SimpleRampedModifier(double ramp) {
        this.ramp = ramp;
    }

    /**
     * Constructor that takes a ramp and a current value
     * @param ramp the amount to ramp the value by to try to reach the base value ({@link #ramp})
     * @param currentVal the current output value of the modifier ({@link #currentVal})
     */
    public SimpleRampedModifier(double ramp, double currentVal) {
        this.ramp = ramp;
        this.currentVal = currentVal;
    }

    /**
     * returns the ramp
     * @return {@link #ramp}
     */
    public double getRamp() {
        return ramp;
    }

    /**
     * sets the ramp
     * @param ramp the amount to ramp the value by to try to reach the base value ({@link #ramp})
     */
    public void setRamp(double ramp) {
        this.ramp = ramp;
    }

    /**
     * returns the current output value
     * @return {@link #currentVal}
     */
    public double getCurrentVal() {
        return currentVal;
    }

    /**
     * sets the current output value
     * @param currentVal the current output value of the modifier ({@link #currentVal})
     */
    public void setCurrentVal(double currentVal) {
        this.currentVal = currentVal;
    }

    /**
     * Applies the ramp to the current value to try to reach the base value
     * @param baseInput the input to apply the modifier to
     * @return the output of the modifier ({@link #currentVal})
     */
    @Override
    public Double apply(Double baseInput) {
        if(currentVal < baseInput) currentVal = Math.min(baseInput, currentVal + ramp);
        else if(currentVal > baseInput) currentVal = Math.max(baseInput, currentVal - ramp);

        return currentVal;
    }
}
