package javacodegeeeks.c03_design_classes_interfaces;

/**
 * Starting Java 8
 * Created by sharath on 7/31/15.
 */
public interface InterfaceWithDefaultMethods {
    void performAction();

    default void performDefaultAction() {
        System.out.println("Default action");
    }

    static void createAction() {
        // Implementation can go here
        System.out.println("Creating...");
    }

}
