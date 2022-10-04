package om.self.supplier.modifiers;

import om.self.supplier.Suppliable;

import java.util.function.Function;


public class DeadZoneModifier<T extends Comparable<T>> implements Suppliable<T> {
    Function<T, T> deadZoneFunction;
    private T deadZoneMin;
    private T deadZoneMax;

    public DeadZoneModifier() {
    }

    public DeadZoneModifier(Function<T, T> deadZoneFunction) {
        this.deadZoneFunction = deadZoneFunction;
    }

    public DeadZoneModifier(T deadZoneMin, T deadZoneMax) {
        this.deadZoneMin = deadZoneMin;
        this.deadZoneMax = deadZoneMax;
    }

    public DeadZoneModifier(Function<T, T> deadZoneFunction, T deadZoneMin, T deadZoneMax) {
        this.deadZoneFunction = deadZoneFunction;
        this.deadZoneMin = deadZoneMin;
        this.deadZoneMax = deadZoneMax;
    }

    public Function<T, T> getDeadZoneFunction() {
        return deadZoneFunction;
    }

    public void setDeadZoneFunction(Function<T, T> deadZoneFunction) {
        this.deadZoneFunction = deadZoneFunction;
    }

    public T getDeadZoneMin() {
        return deadZoneMin;
    }

    public void setDeadZoneMin(T deadZoneMin) {
        this.deadZoneMin = deadZoneMin;
    }

    public T getDeadZoneMax() {
        return deadZoneMax;
    }

    public void setDeadZoneMax(T deadZoneMax) {
        this.deadZoneMax = deadZoneMax;
    }

    public void setDeadZones(T deadZoneMin, T deadZoneMax){
        this.deadZoneMin=deadZoneMin;
        this.deadZoneMax=deadZoneMax;
    }

    @Override
    public T apply(T baseInput) {
        if(baseInput.compareTo(deadZoneMin) < 0 || baseInput.compareTo(deadZoneMax) > 0) return baseInput;
        return deadZoneFunction.apply(baseInput);
    }
}
