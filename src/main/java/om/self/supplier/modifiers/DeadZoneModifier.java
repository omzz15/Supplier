package om.self.supplier.modifiers;

import om.self.supplier.core.SingleTypeModifier;

import java.util.function.Function;

/**
 * A modifier that will apply a function to the input if it is inside a certain range (the dead zone). This is useful for things like dead zones on controllers.
 * @param <T> the type of the input and output of this function (this must be a comparable type)
 */
public class DeadZoneModifier<T extends Comparable<T>> implements SingleTypeModifier<T> {
    /**
     * The function that is applied to the input if it is inside the dead zone
     */
    private Function<T, T> deadZoneFunction;
    /**
     * The minimum value of the dead zone
     */
    private T deadZoneMin;
    /**
     * The maximum value of the dead zone
     */
    private T deadZoneMax;
    private boolean inDeadZone = false;

    /**
     * Default constructor
     * @see #DeadZoneModifier(Function)
     * @see #DeadZoneModifier(T, T)
     *
     * @apiNote you MUST set the dead zone function and dead zone min and max before using this modifier
     */
    public DeadZoneModifier() {
    }

    /**
     * Constructor that sets the dead zone function
     * @param deadZoneFunction the function that is applied to the input if it is inside the dead zone
     * @apiNote you MUST set the dead zone min and max before using this modifier
     */
    public DeadZoneModifier(Function<T, T> deadZoneFunction) {
        this.deadZoneFunction = deadZoneFunction;
    }

    /**
     * Constructor that sets the dead zone min and max
     * @param deadZoneMin the minimum value of the dead zone
     * @param deadZoneMax the maximum value of the dead zone
     * @apiNote you MUST set the dead zone function before using this modifier
     */
    public DeadZoneModifier(T deadZoneMin, T deadZoneMax) {
        this.deadZoneMin = deadZoneMin;
        this.deadZoneMax = deadZoneMax;
    }

    /**
     * Constructor that sets the dead zone function, dead zone min, and dead zone max
     * @param deadZoneFunction the function that is applied to the input if it is inside the dead zone
     * @param deadZoneMin the minimum value of the dead zone
     * @param deadZoneMax the maximum value of the dead zone
     */
    public DeadZoneModifier(Function<T, T> deadZoneFunction, T deadZoneMin, T deadZoneMax) {
        this.deadZoneFunction = deadZoneFunction;
        this.deadZoneMin = deadZoneMin;
        this.deadZoneMax = deadZoneMax;
    }

    /**
     * returns the current dead zone function (the function that is applied to the input if it is inside the dead zone)
     * @return {@link DeadZoneModifier#deadZoneFunction}
     */
    public Function<T, T> getDeadZoneFunction() {
        return deadZoneFunction;
    }

    /**
     * sets the dead zone function (the function that is applied to the input if it is inside the dead zone)
     * @param deadZoneFunction the function that is applied to the input if it is inside the dead zone
     */
    public void setDeadZoneFunction(Function<T, T> deadZoneFunction) {
        this.deadZoneFunction = deadZoneFunction;
    }

    /**
     * returns the current dead zone min (the minimum value of the dead zone)
     * @return {@link DeadZoneModifier#deadZoneMin}
     */
    public T getDeadZoneMin() {
        return deadZoneMin;
    }

    /**
     * sets the dead zone min (the minimum value of the dead zone)
     * @param deadZoneMin the minimum value of the dead zone
     */
    public void setDeadZoneMin(T deadZoneMin) {
        this.deadZoneMin = deadZoneMin;
    }

    /**
     * returns the current dead zone max (the maximum value of the dead zone)
     * @return {@link DeadZoneModifier#deadZoneMax}
     */
    public T getDeadZoneMax() {
        return deadZoneMax;
    }

    /**
     * sets the dead zone max (the maximum value of the dead zone)
     * @param deadZoneMax the maximum value of the dead zone
     */
    public void setDeadZoneMax(T deadZoneMax) {
        this.deadZoneMax = deadZoneMax;
    }

    /**
     * sets the dead zone min and max (the minimum and maximum values of the dead zone)
     * @param deadZoneMin the minimum value of the dead zone
     * @param deadZoneMax the maximum value of the dead zone
     */
    public void setDeadZones(T deadZoneMin, T deadZoneMax){
        this.deadZoneMin=deadZoneMin;
        this.deadZoneMax=deadZoneMax;
    }

    /**
     * returns whether the last input was inside the dead zone
     * @return if the last input was inside the dead zone
     */
    public boolean isInDeadZone() {
        return inDeadZone;
    }

    /**
     * checks if the baseInput is in the dead zone then applies the dead zone function if it is
     * @param baseInput the input to check and fix dead zone for
     */
    @Override
    public T apply(T baseInput) {
        inDeadZone = !(baseInput.compareTo(deadZoneMin) < 0 || baseInput.compareTo(deadZoneMax) > 0);

        if(inDeadZone) return deadZoneFunction.apply(baseInput);
        return baseInput;
    }
}
