package examples;

import om.self.supplier.modifiers.LatchedModifier;

import java.util.LinkedList;
import java.util.List;

/**
 * A simple example of using the {@link LatchedModifier} in both rising and falling edge modes
 */
public class LatchedTest {
    public static void main(String[] args) {
        LatchedModifier rising = new LatchedModifier();
        LatchedModifier falling = new LatchedModifier(LatchedModifier.LatchType.FALLING_EDGE);

        List<Boolean> raw = new LinkedList<>();
        List<Boolean> risingOut = new LinkedList<>();
        List<Boolean> fallingOut = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            boolean val = Math.random() > 0.5;
            raw.add(val);
            risingOut.add(rising.apply(val));
            fallingOut.add(falling.apply(val));
        }

        System.out.print("Raw:\t\t");
        raw.forEach((val) -> System.out.print(val ? '-' : '_'));
        System.out.println();
        System.out.print("Rising:\t\t");
        risingOut.forEach((val) -> System.out.print(val ? '-' : '_'));
        System.out.println();
        System.out.print("Falling:\t");
        fallingOut.forEach((val) -> System.out.print(val ? '-' : '_'));
    }
}
