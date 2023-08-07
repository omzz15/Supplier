package om.self.supplier.modifiers;

import om.self.supplier.core.Modifier;
import om.self.supplier.core.Utils;

/**
 * Converts a number to another number type
 * @param <T> the input type of the function (the type of the number to convert)
 * @param <R> the output type of the function (the type to convert the number to)
 */
public class NumberConverter<T extends Number, R> implements Modifier<T, R> {
    private final Class<R> ref;

    /**
     * Default constructor
     * @param outputRef the class of the output type (Required for casting and checking type)
     */
    public NumberConverter(Class<R> outputRef){
        this.ref = outputRef;
    }

    /**
     * Like default constructor but also takes the input type so java can automatically get the correct {@link T} and {@link R} types
     * @param inputRef the class of the input type (Not needed or used)
     * @param outputRef the class of the output type (Required for casting and checking type)
     *
     * @see #NumberConverter(Class)
     */
    public NumberConverter(Class<T> inputRef, Class<R> outputRef){
        this.ref = outputRef;
    }

    /**
     * Converts the number to the output type
     * @param t the number to convert
     * @return the converted number
     *
     * @see Utils#convertNumber(Number, Class)
     */
    @Override
    public R apply(Number t) {
        return Utils.convertNumber(t, ref);
    }
}
