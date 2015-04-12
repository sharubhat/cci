package oop.final_inner_class;

import javax.swing.*;

/**
 * Created by sharath on 4/10/15.
 *
 * When an anonymous inner class is defined within the body of a method,
 * all variables declared final in the scope of that method are accessible
 * from within the inner class. For scalar values, once it has been assigned,
 * the value of the final variable cannot change. For object values,
 * the reference cannot change.
 * This allows the Java compiler to "capture" the value of the variable at run-time
 * and store a copy as a field in the inner class.
 * Once the outer method has terminated and its stack frame has been removed,
 * the original variable is gone but the inner class's private copy persists in the class's own memory.
 *
 * In below example, since jf is used by inner anonymous class, it must be declared final.
 * If not, it results in compilation error.
 */
public class FooGUI {
    public static void main(String[] args) {
        //initialize GUI components
        final JFrame jf = new JFrame("Hello world!"); //allows jf to be accessed from inner class body
        jf.add(new JButton("Click me"));

        // pack and make visible on the Event-Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                jf.pack(); //this would be a compile-time error if jf were not final
                jf.setLocationRelativeTo(null);
                jf.setVisible(true);
            }
        });
    }
}
