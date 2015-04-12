package oop.method.hiding;

/**
 * Created by sharath on 4/10/15.
 */
public class Cat extends Animal {
    public static void foo() {
        System.out.println("Cat");
    }

    public void bar() {
        System.out.println("Cat");
    }
}
