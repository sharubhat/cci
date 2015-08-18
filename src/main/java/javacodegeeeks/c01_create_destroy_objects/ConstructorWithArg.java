package javacodegeeeks.c01_create_destroy_objects;

/**
 * Created by sharath on 7/31/15.
 */
public class ConstructorWithArg {
    public ConstructorWithArg(final String s1, final String s2) {
        // body here
    }

    public ConstructorWithArg(final String s1) {
        this(s1, "default");
    }

    final ConstructorWithArg constructorWithArgInstance =
            new ConstructorWithArg("arg1", "arg2");


}
