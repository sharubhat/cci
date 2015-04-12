package oop;

/**
 * Created by sharath on 3/19/15.
 */
public class OuterClass {
    class InnerClass {
        private int i = 5;
    }

    // Static nested class is just like any other top-level class.
    // In effect, a static nested class is behaviorally a top-level class
    // that has been nested in another top-level class for packaging convenience.
    static class StaticNestedClass {
        private int i = 5;
    }

    public static void main(String[] args) {

        // Static nested classes are accessed using the enclosing class name
        OuterClass.StaticNestedClass nestedObject =
                new OuterClass.StaticNestedClass();

        // static nested class variable can be accessed in outer class even though it's private
        System.out.println(nestedObject.i);




        // An instance of InnerClass can exist only within an instance of OuterClass
        // and has direct access to the methods and fields of its enclosing instance.

        OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();

        // inner class variable can be accessed in outer class even though it's private
        System.out.println(innerObject.i);
    }

}
