import om.self.supplier.core.Utils;
import om.self.supplier.modifiers.*;
import om.self.supplier.other.Logger;
import om.self.supplier.suppliers.EdgeSupplier;
import om.self.supplier.suppliers.LatchedSupplier;
import om.self.supplier.suppliers.RisingLatchedSupplier;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * This is just a playground for testing the library. It is not part of the library.
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<Integer> iSup = new NumberConverter<>(Double.class, Integer.class).toSupplier(new SimpleRampedModifier(0.5).toSupplier(() -> 10000000.));

        for (int i = 0; i < 100; i++) {
            System.out.println(iSup.get());
        }


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

        DeadZoneModifier<Double> layer2 = new DeadZoneModifier<>(val -> 0.0, 0.0, 0.0);
        Logger<Double> layer3 = new Logger<>();

//        EdgeModifier e = new EdgeModifier();
//        ModifierStack<Object> l4 = new ModifierStack<Object>((in) -> ((Number)in).intValue() > 50, (Function<Object, Object>) e);


        Supplier<Double> stack = new ModifierStack(layer2, layer3).toSupplier(() -> 100.0);

        double val = stack.get();

//        while (val < 100){
//            val = stack.get();
//            if(e.isRisingEdge())
//                System.out.println("rising edge at " + val);
//        }

        System.out.println(layer3.getLog());


        Supplier<Boolean> sup = new LatchedModifier().toSupplier(() -> {
            boolean b = Math.random() > 0.7;
            System.out.println(b ? "+" : "-");
            return b;
        });

        for (int i = 0; i < 1000; i++) {
            System.out.println("sup: " + (sup.get() ? "+" : "-"));
        }

    }
}
