package om.self.supplier;

import java.util.function.Function;
import java.util.function.Supplier;

public abstract class ModifiableSupplierImpl<T> implements ModifiableSupplier<T> {
    private Supplier<T> baseSupplier;

    public ModifiableSupplierImpl() {
    }

    public ModifiableSupplierImpl(Supplier<T> baseSupplier) {
        this.baseSupplier = baseSupplier;
    }

    public Supplier<T> getBaseSupplier() {
        return baseSupplier;
    }

    public void setBaseSupplier(Supplier<T> baseSupplier) {
        this.baseSupplier = baseSupplier;
    }
}
