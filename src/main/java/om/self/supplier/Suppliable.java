package om.self.supplier;

import java.util.function.Function;
import java.util.function.Supplier;

public interface Suppliable<T> extends Function<T, T> {
    default Supplier<T> toSupplier(Supplier<T> base){
        return () -> apply(base.get());
    }
}
