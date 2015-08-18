package javacodegeeeks.c03_design_classes_interfaces;

/**
 * Created by sharath on 8/1/15.
 */
public class Child extends Parent implements Parent.ProtectedInterface {
    @Override
    protected void protectedAction() {
        super.protectedAction();
    }

    @Override
    void packageAction() {
        // Do nothing, no call to parent's method
    }

    public void childAction() {
        this.protectedField = "value";
    }
}
