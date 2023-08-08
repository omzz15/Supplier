package om.self.supplier.suppliers;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Allows for a supplier to be linked to a conversion function to change its output. <br>
 * Note:
 * This is an old class
 * that can probably be better replaced by {@link om.self.supplier.core.ModifierImpl} and the toSupplier() method.
 * @param <T> the input type
 * @param <R> the output type
 * @deprecated use the {@link om.self.supplier.core.ModifierImpl} and the toSupplier() method instead
 */
@Deprecated
public class LinkedSupplier<T, R> implements Supplier<R> {
    T input;
    Function<T, R> conversionFunction;

    /**
     * Default constructor
     */
    public LinkedSupplier() {
    }

    /**
     * Constructor that sets the input
     * @param input the input
     */
    public LinkedSupplier(T input) {
        this.input = input;
    }

    /**
     * Constructor that sets the conversion function
     * @param conversionFunction the conversion function applied to the input
     */
    public LinkedSupplier(Function<T, R> conversionFunction) {
        this.conversionFunction = conversionFunction;
    }

    /**
     * Constructor that sets the input and conversion function
     * @param input the input
     * @param conversionFunction the conversion function applied to the input
     */
    public LinkedSupplier(T input, Function<T, R> conversionFunction) {
        this.input = input;
        this.conversionFunction = conversionFunction;
    }

    /**
     * Returns the input
     * @return {@link LinkedSupplier#input}
     */
    public T getInput() {
        return input;
    }

    /**
     * Sets the input
     * @param input the input
     */
    public void setInput(T input) {
        this.input = input;
    }

    /**
     * Returns the conversion function
     * @return {@link LinkedSupplier#conversionFunction}
     */
    public Function<T, R> getConversionFunction() {
        return conversionFunction;
    }

    /**
     * Sets the conversion function
     * @param conversionFunction the conversion function applied to the input
     */
    public void setConversionFunction(Function<T, R> conversionFunction) {
        this.conversionFunction = conversionFunction;
    }

    /**
     * Applies the conversion function to the input and returns the result
     * @return the result of the conversion function applied to the input
     */
    @Override
    public R get() {
        return conversionFunction.apply(input);
    }
}
