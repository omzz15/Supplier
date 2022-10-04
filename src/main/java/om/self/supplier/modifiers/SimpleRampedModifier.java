package om.self.supplier.modifiers;

import om.self.supplier.Suppliable;
import om.self.supplier.Utils;

public class SimpleRampedModifier<T extends Number> implements Suppliable<T> {
    private T ramp;
    private T currentVal;

    public SimpleRampedModifier() {
    }

    public SimpleRampedModifier(T ramp) {
        this.ramp = ramp;
    }

    public SimpleRampedModifier(T ramp, T currentVal) {
        this.ramp = ramp;
        this.currentVal = currentVal;
    }

    public T getRamp() {
        return ramp;
    }

    public void setRamp(T ramp) {
        this.ramp = ramp;
    }

    public T getCurrentVal() {
        return currentVal;
    }

    public void setCurrentVal(T currentVal) {
        this.currentVal = currentVal;
    }

    public void clear(){
        currentVal = null;
    }

    @Override
    public T apply(T baseInput) {
        if(currentVal == null) currentVal = baseInput;

        double input = baseInput.doubleValue();
        double curr = currentVal.doubleValue();
        double ramp = this.ramp.doubleValue();

        if(input > curr) currentVal = Utils.convertNumber(Math.min(input, curr + ramp), currentVal);
        else if(input < curr) currentVal = Utils.convertNumber(Math.max(input, curr - ramp), currentVal);

        return currentVal;
    }
}
