package om.self.supplier.modifiers;

public class LatchedModifier extends EdgeExModifier{
    private boolean latchValue = false;

    public LatchedModifier() {
        setLatchType(LatchType.RISING_EDGE);
    }

    public LatchedModifier(boolean latchValue) {
        this.latchValue = latchValue;
        setLatchType(LatchType.RISING_EDGE);
    }

    public boolean getLatchValue() {
        return latchValue;
    }

    public void setLatchValue(boolean latchValue) {
        this.latchValue = latchValue;
    }

    public void invertLatchValue(){
        latchValue = !latchValue;
    }

    public void setLatchType(LatchType type){
        switch(type){
            case RISING_EDGE:
                setOnFall(() -> {});
                setOnRise(this::invertLatchValue);

            case FALLING_EDGE:
                setOnRise(() -> {});
                setOnFall(this::invertLatchValue);
        }
    }

    @Override
    public Boolean apply(Boolean value){
        super.apply(value);
        return latchValue;
    }

    public enum LatchType{
        RISING_EDGE,
        FALLING_EDGE,
    }
}