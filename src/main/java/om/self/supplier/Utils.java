package om.self.supplier;

import java.math.BigDecimal;

public class Utils {
    public static BigDecimal toBigDecimal(String val){
        return new BigDecimal(val);
    }

    public  static BigDecimal toBigDecimal(Number num){
        return toBigDecimal(num.toString());
    }
}
