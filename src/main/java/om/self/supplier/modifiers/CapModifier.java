package om.self.supplier.modifiers;

import om.self.supplier.Suppliable;

public class CapModifier <T extends Comparable<T>> implements Suppliable<T> {
    private T minCap;
    private T maxCap;

    private boolean belowRange = false;
    private boolean aboveRange = false;


    public CapModifier() {}

    public CapModifier(T minCap, T maxCap) {
        this.minCap = minCap;
        this.maxCap = maxCap;
    }

    public T getMinCap() {
        return minCap;
    }

    public void setMinCap(T minCap) {
        this.minCap = minCap;
    }

    public T getMaxCap() {
        return maxCap;
    }

    public void setMaxCap(T maxCap) {
        this.maxCap = maxCap;
    }

    public void setCaps(T minCap, T maxCap){
        this.minCap = minCap;
        this.maxCap = maxCap;
    }

    public boolean isInRange() {
        return !(belowRange || aboveRange);
    }

    public boolean isBelowRange() {
        return belowRange;
    }

    public boolean isAboveRange(){
        return aboveRange;
    }

    @Override
    public T apply(T baseInput) {
        belowRange = baseInput.compareTo(minCap) < 0;
        if(belowRange){
            aboveRange = false;
            return minCap;
        }
        aboveRange = baseInput.compareTo(maxCap) > 0;
        if(aboveRange) return maxCap;
        return baseInput;
    }
}
