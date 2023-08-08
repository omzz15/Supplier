package om.self.supplier.modifiers;

import om.self.supplier.core.SingleTypeModifier;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * use this instead of {@link ConditionalModifier} if the return and input types are the same because it runs faster.
 * @param <T> the type of the input and output
 *
 * @see ConditionalModifier
 */
public class SingleTypeConditionalModifier<T> implements SingleTypeModifier<T> {
    /**
     * the condition that will determine if the modification is run
     */
    Supplier<Boolean> condition;
    /**
     * modification to make to base input
     */
    Function<T, T> modification;

    /**
     * default constructor <br>
     * IMPORTANT:
     * you must set the condition and modification
     * before using this modifier else it will throw a {@link NullPointerException}.
     */
    public SingleTypeConditionalModifier() {
    }

    /**
     * Recommended constructor that sets the condition and modification
     * @param condition the condition that will determine if the modification is run
     * @param modification modification to make to base input
     */
    public SingleTypeConditionalModifier(Supplier<Boolean> condition, Function<T, T> modification) {
        this.condition = condition;
        this.modification = modification;
    }

    /**
     * returns the condition
     * @return {@link SingleTypeConditionalModifier#condition}
     */
    public Supplier<Boolean> getCondition() {
        return condition;
    }

    /**
     * sets the condition
     * @param condition the condition that will determine if the modification is run
     */
    public void setCondition(Supplier<Boolean> condition) {
        this.condition = condition;
    }

    /**
     * returns the modification
     * @return {@link SingleTypeConditionalModifier#modification}
     */
    public Function<T, T> getModification() {
        return modification;
    }

    /**
     * sets the modification
     * @param modification modification to make to base input
     */
    public void setModification(Function<T, T> modification) {
        this.modification = modification;
    }

    /**
     * Runs the modification if the condition is true else returns the base input
     * @param baseInput the input
     * @return the modified input or the base input
     */
    @Override
    public T apply(T baseInput) {
        return condition.get() ? modification.apply(baseInput) : baseInput;
    }
}
