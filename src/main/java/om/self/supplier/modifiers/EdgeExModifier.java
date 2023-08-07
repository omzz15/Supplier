package om.self.supplier.modifiers;

/**
 * An extension of {@link EdgeModifier} that allows for a runnable to be run on rising and falling edges.
 */
public class EdgeExModifier extends EdgeModifier {
    /**
     * The runnable to run on rising edges.
     */
    private Runnable onRise = () -> {};

    /**
     * The runnable to run on falling edges.
     */
    private Runnable onFall = () -> {};

    /**
     * Default constructor that has blank {@link #onRise} and {@link #onFall} runnables.
     * @see #EdgeExModifier(Runnable, Runnable)
     */
    public EdgeExModifier(){}

    /**
     * Constructor that sets the {@link #onRise} and {@link #onFall} runnables.
     * @param onRise the runnable to run on rising edges
     * @param onFall the runnable to run on falling edges
     */
    public EdgeExModifier(Runnable onRise, Runnable onFall) {
        this.onRise = onRise;
        this.onFall = onFall;
    }

    /**
     * Gets the runnable that runs on rising edges.
     * @return {@link #onRise}
      */
    public Runnable getOnRise() {
        return onRise;
    }

    /**
     * Sets the runnable that runs on rising edges.
     * @param onRise the runnable to run on rising edges
     */
    public void setOnRise(Runnable onRise) {
        if (onRise == null) throw new IllegalArgumentException("onRise can not be null");
        this.onRise = onRise;
    }

    /**
     * Gets the runnable that runs on falling edges.
     * @return {@link #onFall}
     */
    public Runnable getOnFall() {
        return onFall;
    }

    /**
     * Sets the runnable that runs on falling edges.
     * @param onFall the runnable to run on falling edges
     */
    public void setOnFall(Runnable onFall) {
        if (onFall == null) throw new IllegalArgumentException("onFall can not be null");
        this.onFall = onFall;
    }

    /**
     * Applies the modification and runs the runnables if needed.
     * @param value the value to apply the modification to
     * @return the original value
     */
    @Override
    public Boolean apply(Boolean value) {
        super.apply(value);

        if(isRisingEdge()) onRise.run();
        else if(isFallingEdge()) onFall.run();

        return value;
    }
}
