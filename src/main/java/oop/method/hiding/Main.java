package oop.method.hiding;

/**
 * Created by sharath on 4/10/15.
 */
public class Main {
    public static void main(String[] args) {
        Animal.foo();
        Cat.foo();

        System.out.println("\n");

        // Static method call looks at
        // reference type and executes
        // even if the reference is not pointing to any real object
        Animal a = new Animal();
        Animal b = new Cat();
        Cat c = new Cat();
        Animal d = null;

        // By definition Cat.foo() is said to hide Animal.foo()
        // but actually what happens is Cat's method will be hidden by Animal's
        a.foo();    // Animal
        b.foo();    // Animal
        c.foo();    // Cat
        d.foo();    // Animal

        System.out.println("\n");

        // non-static method call looks at
        // object type the reference is pointing to,
        // so throws null pointer exception if reference
        // is pointing to null
        a.bar();    // Animal
        b.bar();    // Cat
        c.bar();    // Cat
        // throws null pointer exception
        // d.bar();

        System.out.println("\n");

        // if method is present only in parent,
        // then child inherits it
        // again object type is considered and not reference type
        a.foobar();    // Animal
        b.foobar();    // Animal
        c.foobar();    // Animal
    }
}
