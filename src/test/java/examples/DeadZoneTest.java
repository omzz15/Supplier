package examples;

import om.self.supplier.modifiers.DeadZoneModifier;
import om.self.supplier.other.Logger;

import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.DoubleStream;

/**
 * A simple example of using the {@link DeadZoneModifier}
 */
public class DeadZoneTest {
    public static void main(String[] args) {
        DeadZoneModifier<Integer> d = new DeadZoneModifier<>(val -> 0, -1, 1);

        PrimitiveIterator.OfInt randoms = new Random().ints(-5, 5).iterator();

        for (int i = 0; i < 100; i++) {
            int val = randoms.next();
            System.out.printf("%2d -> %2d\n", val, d.apply(val));
        }
    }
}
