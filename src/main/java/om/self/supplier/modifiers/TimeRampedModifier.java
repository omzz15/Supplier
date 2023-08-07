package om.self.supplier.modifiers;

/**
 * Extends {@link SimpleRampedModifier} to ramp the value based on the time elapsed since the last update instead of every time {@link #apply(Double)} is called
 */
public class TimeRampedModifier extends SimpleRampedModifier {
    /**
     * The amount to ramp the value by (every ms) to try to reach the base value
     */
    private double rampPerMs;
    private long lastUpdateTime = System.nanoTime();

    /**
     * Constructor that takes a ramp speed and sets the current value to 0
     * @param rampPerMs how much to ramp the value by every MS
     */
    public TimeRampedModifier(double rampPerMs) {
        this.rampPerMs = rampPerMs;
    }

    /**
     * Constructor that sets both the ramp speed and current value
     * @param rampPerMs how much to ramp the value by every MS
     * @param currentVal the current output value of this modifier
     */
    public TimeRampedModifier(double rampPerMs, double currentVal) {
        super(0, currentVal);
        this.rampPerMs = rampPerMs;
    }

    /**
     * Returns the current ramp speed in amount/millisecond
     * @return {@link #rampPerMs}
     */
    public double getRampPerMs() {
        return rampPerMs;
    }

    /**
     * Sets the current ramp speed in amount/millisecond
     * @param rampPerMs how much to ramp the value by every MS
     */
    public void setRampPerMs(double rampPerMs) {
        this.rampPerMs = rampPerMs;
    }

    /**
     * Sets the current value and resets the last update time
     * @param currentVal the current output value of the modifier
     */
    @Override
    public void setCurrentVal(double currentVal) {
        super.setCurrentVal(currentVal);
        lastUpdateTime = System.nanoTime();
    }

    /**
     * Updates the ramp based on the time elapsed since the last update and then calls {@link SimpleRampedModifier#apply(Double)}
     * @param baseInput the base input value to try to reach
     * @return the current output value of the modifier
     */
    @Override
    public Double apply(Double baseInput) {
        setRamp(getElapsedMs() * rampPerMs);
        return super.apply(baseInput);
    }

    /**
     * Calculates the time elapsed since the last update and resets the last update time
     * @return the time elapsed since the last update
     */
    private double getElapsedMs(){
        long curr = System.nanoTime();
        double val = (curr - lastUpdateTime) / 1000000.0;
        lastUpdateTime = curr;
        return val;
    }
}
