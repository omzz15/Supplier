package om.self.supplier.consumer;

import java.util.function.Consumer;

/**
 * A consumer that can be used to detect rising and falling edges for boolean values. Just have this consumer consume a stream of booleans and use {@link #setOnRise(Runnable)} and {@link #setOnFall(Runnable)} or {@link #isRisingEdge()} and {@link #isFallingEdge()} to preform actions.
 */
public class EdgeConsumer implements Consumer<Boolean> {
    private boolean currVal;
    private boolean lastVal;

    /**
     * The runnable to run when a rising edge is detected.
     */
    private Runnable onRise = () -> {};

    /**
     * The runnable to run when a falling edge is detected.
     */
    private Runnable onFall = () -> {};

    /**
     * Creates a new edge consumer with empty {@link #onFall} and {@link #onRise} runnable.
     */
    public EdgeConsumer(){}

    /**
     * Creates a new edge consumer with the given {@link #onFall} and {@link #onRise} runnable.
     * @param onRise the runnable to run when a rising edge is detected.
     * @param onFall the runnable to run when a falling edge is detected.
     */
    public EdgeConsumer(Runnable onRise, Runnable onFall) {
        setOnRise(onRise);
        setOnFall(onFall);
    }

    /**
     * Gets the runnable that will run when a rising edge is detected.
     * @return {@link #onRise}
     */
    public Runnable getOnRise() {
        return onRise;
    }

    /**
     * Sets the runnable that will run when a rising edge is detected.
     * @param onRise the runnable to run when a rising edge is detected.
     *
     * @throws IllegalArgumentException if onRise is null.
     */
    public void setOnRise(Runnable onRise) {
        if (onRise == null) throw new IllegalArgumentException("onRise can not be null");
        this.onRise = onRise;
    }

    /**
     * Gets the runnable that will run when a falling edge is detected.
     * @return {@link #onFall}
     */
    public Runnable getOnFall() {
        return onFall;
    }

    /**
     * Sets the runnable that will run when a falling edge is detected.
     * @param onFall the runnable to run when a falling edge is detected.
     *
     * @throws IllegalArgumentException if onFall is null.
     */
    public void setOnFall(Runnable onFall) {
        if (onFall == null) throw new IllegalArgumentException("onFall can not be null");
        this.onFall = onFall;
    }

    /**
     * Accepts a boolean value and runs the {@link #onRise} runnable if a rising edge is detected, or the {@link #onFall} runnable if a falling edge is detected.
     * @param value the value to check the edge on.
     */
    @Override
    public void accept(Boolean value) {
        lastVal = currVal;
        currVal = value;

        if(isRisingEdge()) onRise.run();
        else if(isFallingEdge()) onFall.run();
    }

    /**
     * returns if the last 2 values accepted made a rising edge.
     * @return if the last 2 values were a rising edge.
     */
    public boolean isRisingEdge(){
        return !lastVal && currVal;
    }

    /**
     * returns if the last 2 values accepted made a falling edge.
     * @return if the last 2 values were a falling edge.
     */
    public boolean isFallingEdge(){
        return lastVal && !currVal;
    }
}
