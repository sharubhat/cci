package javacodegeeeks.c03_design_classes_interfaces;

/**
 * Created by sharath on 8/1/15.
 */
public class Encapsulation {
    private final String email;
    private String address;

    public Encapsulation(final String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }
}
