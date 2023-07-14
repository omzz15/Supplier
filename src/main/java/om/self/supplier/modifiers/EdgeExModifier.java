package om.self.supplier.modifiers;

import om.self.supplier.core.SingleTypeModifier;

public class EdgeExModifier extends EdgeModifier {
    private Runnable onRise = () -> {};

    private Runnable onFall = () -> {};

    public EdgeExModifier(){}

    public EdgeExModifier(Runnable onRise, Runnable onFall) {
        this.onRise = onRise;
        this.onFall = onFall;
    }

    public Runnable getOnRise() {
        return onRise;
    }

    public void setOnRise(Runnable onRise) {
        if (onRise == null) throw new IllegalArgumentException("onRise can not be null");
        this.onRise = onRise;
    }

    public Runnable getOnFall() {
        return onFall;
    }

    public void setOnFall(Runnable onFall) {
        if (onFall == null) throw new IllegalArgumentException("onFall can not be null");
        this.onFall = onFall;
    }

    @Override
    public Boolean apply(Boolean value) {
        super.apply(value);

        if(isRisingEdge()) onRise.run();
        else if(isFallingEdge()) onFall.run();

        return value;
    }
}
