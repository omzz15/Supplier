package om.self.supplier.modifiers;

import om.self.supplier.core.Modifier;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * A modifier that only applies the modification if the condition is true. This is useful for things like toggles.
 * @param <T> the input type of the function
 * @param <R> the output type of the function
 */
public class ConditionalModifier<T, R> implements Modifier<T, R> {
    /**
     * The condition that must be true for the modification to be applied
     */
    private Supplier<Boolean> condition = () -> false;
    /**
     * The modification that is applied if the condition is true
     */
    private Function<T, R> modification = (t) -> null;
    /**
     * The base function that is applied if the condition is false
     */
    private Function<T, R> base = (t) -> null;

    /**
     * Default constructor
     * @see #ConditionalModifier(Supplier, Function, Function)
     */
    public ConditionalModifier() {
    }

    /**
     * Recommended constructor that sets all the fields needed for this modifier.
     * @param condition the condition that must be true for the modification to be applied
     * @param base the base function that is applied if the condition is false
     * @param modification the modification that is applied if the condition is true
     */
    public ConditionalModifier(Supplier<Boolean> condition, Function<T,R> base, Function<T, R> modification) {
        this.condition = condition;
        this.base = base;
        this.modification = modification;
    }

    /**
     * returns the condition (the supplier that must be true for the modification to be applied)
     * @return {@link ConditionalModifier#condition}
     */
    public Supplier<Boolean> getCondition() {
        return condition;
    }

    /**
     * sets the condition
     * @param condition the condition that must be true for the modification to be applied
     *
     * @throws NullPointerException if condition is null
     */
    public void setCondition(Supplier<Boolean> condition) {
        if(condition == null) throw new NullPointerException("condition cannot be null");
        this.condition = condition;
    }

    /**
     * returns the modification (the function that is applied if the condition is true)
     * @return {@link ConditionalModifier#modification}
     */
    public Function<T, R> getModification() {
        return modification;
    }

    /**
     * sets the modification
     * @param modification the modification that is applied if the condition is true
     *
     * @throws NullPointerException if modification is null
     */
    public void setModification(Function<T, R> modification) {
        this.modification = modification;
    }

    /**
     * returns the base (the function that is applied if the condition is false)
     * @return {@link ConditionalModifier#base}
     */
    public Function<T, R> getBase() {
        return base;
    }

    /**
     * sets the base
     * @param base the base function that is applied if the condition is false
     *
     * @throws NullPointerException if base is null
     */
    public void setBase(Function<T, R> base) {
        if(base == null) throw new NullPointerException("base cannot be null");
        this.base = base;
    }

    /**
     * applies the modification if the condition is true else applies the base
     * @param baseInput the input to the base function
     * @return the output of the base or modification function
     */
    @Override
    public R apply(T baseInput) {
        return condition.get() ? modification.apply(baseInput) : base.apply(baseInput);
    }
}
