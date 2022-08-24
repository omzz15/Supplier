import om.self.supplier.*;

import java.math.BigDecimal;

public class SupplierTest {
    public static void main(String[] args) {
        SimpleRampedSupplier layer1 = new TimeRampedSupplier(null, Utils.toBigDecimal(1), Utils.toBigDecimal(0.0));
        DeadZoneSupplier<Double> layer2 = new DeadZoneSupplier(null, val -> 0.0, 0.0, 0.0);
        SupplierStack<Double> stack = new SupplierStack<>(() -> 100.0, (num) -> layer1.apply(Utils.toBigDecimal(num)).doubleValue(), layer2);

        double val = stack.get();

        while (val < 100){
            if((int)val == 90)
                layer1.setCurrentVal(Utils.toBigDecimal(99));
            System.out.println(val);
            val = stack.get();
        }
    }
}
