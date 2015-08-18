package javacodegeeeks.c01_create_destroy_objects;

/**
 * Created by sharath on 7/31/15.
 */
public class InitializationBlockAndConstructor {

    // all initialization blocks are executed in order of appearance before executing the constructor
    {
        System.out.println("I am printed first");
    }

    public InitializationBlockAndConstructor() {
        System.out.println("I am printed third");
    }

    {
        System.out.println("I am printed second");
    }

    public static void main(String[] args) {
        InitializationBlockAndConstructor i = new InitializationBlockAndConstructor();
    }

}
