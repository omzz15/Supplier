import om.self.supplier.ModifierStack;
import om.self.supplier.modifiers.LatchedModifier;

public class SupplierTest {
    public static void main(String[] args) {
        LatchedModifier l = new LatchedModifier();

        for (int i = 0; i < 100; i++) {
            boolean val = Math.random() < 0.5;
            l.apply(val);

            System.out.println("raw: " + val + " , latched: " + l.getLatchValue());
        }

//        DeadZoneModifier<Double> layer2 = new DeadZoneModifier<>(val -> 0.0, 0.0, 0.0);
//        Logger<Double> layer3 = new Logger<>();
//
//        EdgeModifier e = new EdgeModifier();
//        Stack l4 = new Stack((in) -> ((Number)in).intValue() > 50, e);
//
//
//        Supplier<Double> stack = new ModifierStack(layer1, layer2, layer3, layer4).toSupplier(() -> 100.0);
//
//        double val = stack.get();
//
//        while (val < 100){
//            val = stack.get();
//            if(e.isRisingEdge())
//                System.out.println("rising edge at " + val);
//        }

        //System.out.println(layer3.getLog());
    }
}
