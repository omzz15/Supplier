package om.self.supplier;

import java.lang.reflect.Type;

public class Utils {

    public static<T> T convertNumber(Number number, T ref){
        if(ref instanceof Integer) return (T)(Number)number.intValue();
        else if (ref instanceof Double) return (T)(Number)number.doubleValue();
        else if (ref instanceof Float) return (T)(Number)number.floatValue();
        else if (ref instanceof Short) return (T)(Number)number.shortValue();
        else if (ref instanceof Long) return (T)(Number)number.longValue();
        else return (T)number;
    }
}
