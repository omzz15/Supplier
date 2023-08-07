package examples;

import om.self.supplier.modifiers.EdgeExModifier;

public class EdgeExTest {
    public static void main(String[] args) {
        EdgeExModifier detector = new EdgeExModifier(() -> System.out.print("Rising"), () -> System.out.print("Falling"));

        for (int i = 0; i < 100; i++) {
            boolean val = Math.random() > 0.7;
            System.out.print(val + " -> ");
            detector.apply(val);
            System.out.println();
        }
    }
}
