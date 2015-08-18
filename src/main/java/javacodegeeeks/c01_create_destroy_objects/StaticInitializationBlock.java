package javacodegeeeks.c01_create_destroy_objects;

/**
 * Created by sharath on 7/31/15.
 */
public class StaticInitializationBlock {
    static {
        System.out.println("I am static, I must run first and only once");
    }

    {
        System.out.println("I must run after static block and every time");
    }

    public StaticInitializationBlock() {
        System.out.println("I am constructor and I am the last one to run before object creation is complete.");
    }

    public static void main(String[] args) {
        StaticInitializationBlock s = new StaticInitializationBlock();
        StaticInitializationBlock s1 = new StaticInitializationBlock();
    }

}
