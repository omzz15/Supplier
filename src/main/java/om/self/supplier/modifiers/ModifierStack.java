package om.self.supplier.modifiers;

import om.self.supplier.core.SingleTypeModifier;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Function;

/**
 * Allows you to stack multiple modifiers together
 * @param <T> the type of the modifiers in the stack (note: all modifiers must be this type and the input and output are also this type)
 */
public class ModifierStack<T> implements SingleTypeModifier<T> {
    /**
     * The stack of modifiers to be run in order when {@link ModifierStack#apply(Object)} is called
     */
    private LinkedList<Function<T, T>> stack = new LinkedList<>();

    /**
     * Default constructor which creates an empty stack
     */
    public ModifierStack() {
    }

    /**
     * Constructor that takes a stack of modifiers as the stack
     * @param stack the stack of modifiers
     */
    public ModifierStack(LinkedList<Function<T, T>> stack) {
        setStack(stack);
    }

    /**
     * Constructor that takes a vararg of modifiers as the stack
     * @param functions the stack of modifiers
     */
    @SafeVarargs
    public ModifierStack(Function<T, T>... functions) {
        addToStack(functions);
    }

    /**
     * returns the stack of modifiers
     * @return {@link ModifierStack#stack}
     */
    public LinkedList<Function<T, T>> getStack() {
        return stack;
    }

    /**
     * sets the stack of modifiers
     * @param stack the stack of modifiers
     */
    public void setStack(LinkedList<Function<T, T>> stack) {
        this.stack = stack;
    }

    /**
     * adds a modifier to the stack
     * @param function the modifier to add
     */
    public void addToStack(Function<T, T> function) {
        stack.add(function);
    }

    /**
     * adds multiple modifiers to the stack
     * @param functions the modifiers to add
     */
    public void addToStack(Function<T, T>... functions) {
        stack.addAll(Arrays.asList(functions));
    }

    /**
     * removes a modifier from the stack based on index in {@link #stack}
     * @param location the location of the modifier to remove
     */
    public void removeFromStack(int location){
        stack.remove(location);
    }

    /**
     * removes a modifier from the stack based on the modifier itself
     * @param function the modifier to remove
     * @return true if the modifier was removed, false if it was not in the stack
     */
    public boolean removeFromStack(Function<T,T> function){
        return stack.remove(function);
    }

    /**
     * Runs all the modifiers in the stack in order
     * @param baseInput the input to the first modifier in the stack
     * @return the output of the last modifier in the stack
     */
    @Override
    public T apply(T baseInput) {
        for (Function<T, T> func : stack) {
            baseInput = func.apply(baseInput);
        }
        return baseInput;
    }
}
