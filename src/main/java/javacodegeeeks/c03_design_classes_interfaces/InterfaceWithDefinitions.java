package javacodegeeeks.c03_design_classes_interfaces;

/**
 * Created by sharath on 7/31/15.
 */
public interface InterfaceWithDefinitions {
    String CONSTANT = "constant";

    enum InnerEnum {
        E1, E2;
    }

    class Innerclass {

    }

    interface InnerInterface {

    }

    void performaAction();
}
