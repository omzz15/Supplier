package examples;

import om.self.supplier.modifiers.DeadZoneModifier;
import om.self.supplier.other.Logger;

import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.DoubleStream;

public class DeadZoneTest {
    public static void main(String[] args) {
        DeadZoneModifier<Double> d = new DeadZoneModifier<>(val -> 0.0, -1.0, 1.0);
        Logger<Double> l = new Logger<>();

        PrimitiveIterator.OfDouble randoms = new Random().doubles(-2.0, 2.0).iterator();

        for (int i = 0; i < 100; i++) {
            double val = randoms.next();
            System.out.println(val + " -> " + l.apply(d.apply(val)));
        }

        try {
            l.writeToFile("./deadzone.log", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
