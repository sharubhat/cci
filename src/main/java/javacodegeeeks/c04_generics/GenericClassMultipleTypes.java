package javacodegeeeks.c04_generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharath on 8/1/15.
 */
public class GenericClassMultipleTypes<T, R> implements GenericInterfaceMultipleTypes<T, R> {
    @Override
    public R performAction(T action) {
        return null;
    }

    // Note, it's not necessary to provide types in the method signature. Following is also correct
    // public R performAction2(final T action) {
    public <T, R> R performAction2(final T action) {
        return null;
    }

    // It's not necessary to use types of their owner, methods can declare their own generic types.
    public <X, Y> Y performAnotherAction(final X action) {
        return null;
    }

    public GenericClassMultipleTypes(final T init) {

    }

    public <K, L> GenericClassMultipleTypes(final K init, final L init2) {

    }

    // ? super Integer enforces a condition that type being passed must be same class or super class.
    // iterate() can accept List<Integer> or List<Number>
    public void iterate( final List< ? super Integer > objects ) {
        // Some implementation here
    }

    public static void main(String[] args) {
        GenericClassMultipleTypes<Long, String> g = new GenericClassMultipleTypes<>(5, "Apple");
        List<Number> c = new ArrayList<>();
        g.iterate(c);
    }
}
