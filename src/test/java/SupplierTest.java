import om.self.supplier.ModifierStack;
import om.self.supplier.modifiers.CapModifier;
import om.self.supplier.modifiers.LatchedModifier;
import om.self.supplier.modifiers.TimeRampedModifier;

public class SupplierTest {
    public static void main(String[] args) {
        TimeRampedModifier t = new TimeRampedModifier(.001, 0);
        CapModifier<Double> c = new CapModifier<>(-1.,0.);

        double startTime = .01;
        double endTime = 1;
        double step = 0.01;
        int trials = 100;
        //double[] errors = new double[endTime - startTime + 1];
        boolean printAsData = true;

        for (double time = startTime; time <= endTime; time+= step) {
            c.setMaxCap(t.getRampPerMs() * time);
            double error = 0;

            for (int i = 0; i < trials; i++) {
                t.setCurrentVal(0);
                c.apply(0.0);
                long start = System.nanoTime();
                while (c.isInRange()) c.apply(t.apply(Double.MAX_VALUE));

                error += (System.nanoTime() - start) - time * 1000000.;
            }

            error /= trials;
            //errors[time - startTime] = error;

            if(printAsData) System.out.println(time + ", " + error);
            else System.out.println("Error at time " + time +" ms is: " + error + " ns");
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
