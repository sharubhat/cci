package javacodegeeeks.c03_design_classes_interfaces;

/**
 * Created by sharath on 7/31/15.
 */
public class AnonymousClass {
    public static void main(String[] args) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Running inside an anonymous class");
                    }
                }
        ).start();


        // java 8 functional interface(Runnable)
        new Thread(() -> {
            System.out.println("Running inside lambda");
        }).start();
    }
}
