package om.self.supplier;

import java.util.function.Function;
import java.util.function.Supplier;

public interface ModifiableSupplier<T> extends Supplier<T>, Function<T, T> {
    Supplier<T> getBaseSupplier();
    void setBaseSupplier(Supplier<T> baseSupplier);
    T apply(T baseInput);

    default T get(){
        return apply(getBaseSupplier().get());
    }
}
