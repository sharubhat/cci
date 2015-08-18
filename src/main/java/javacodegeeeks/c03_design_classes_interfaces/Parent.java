package javacodegeeeks.c03_design_classes_interfaces;

/**
 * Created by sharath on 7/31/15.
 */
public class Parent {
    // visible to everyone
    public static final String CONSTANT = "Constant";

    public void publicAction() {

    }

    // visible to none
    private String privateField;

    private class PrivateClass {

    }

    private void privateAction() {

    }

    // visible to subclass
    protected String protectedField;

    protected interface ProtectedInterface {

    }

    protected void protectedAction(){

    }

    // visible to subclasses in same package
    void packageAction() {

    }

}
