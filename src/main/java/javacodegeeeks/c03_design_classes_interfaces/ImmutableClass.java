package javacodegeeeks.c03_design_classes_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by sharath on 7/31/15.
 */
public class ImmutableClass {
    private final long id;
    private final String[] arrayOfStrings;
    private final Collection<String> collectionOfStrings;

    public ImmutableClass(final long id, final String[] arrayOfStrings,
                          final Collection<String> collectionOfStrings) {
        this.id = id;
        this.arrayOfStrings = Arrays.copyOf(arrayOfStrings, arrayOfStrings.length);
        this.collectionOfStrings = new ArrayList<>(collectionOfStrings);
    }

    public Collection<String> getCollectionOfStrings() {
        return Collections.unmodifiableCollection(collectionOfStrings);
    }

    public String[] getArrayOfStrings() {
        return Arrays.copyOf(arrayOfStrings, arrayOfStrings.length);
    }
}
