package core;

/**
 * Created by sharath on 3/20/15.
 *
 * Question 1: When you compile a program written in the Java programming language,
 * the compiler converts the human-readable source file into platform-independent code
 * that a Java Virtual Machine can understand. What is this platform-independent code called?
 *
 * Answer: Bytecode
 *
 * Question 2: Which of the following is not a valid comment:

 * a. /** comment * /
 * b. /* comment * /
 * c. /* comment
 * d. // comment
 *
 * Answer: /* comment (Choice c)
 *
 * Question 3: What is the first thing you should check if you see the following error at runtime:

 * Exception in thread "main" java.lang.NoClassDefFoundError:
 * HelloWorldApp.java.
 *
 * Answer: Check your Classpath. Generated .class file can not be found by jvm.
 *
 * Question 4: What is the correct signature of the main method?
 *
 * Answer: public static void main(String[] args)
 *
 * Question 5: When declaring the main method, which modifier must come first, public or static?
 *
 * Answer: Does not matter
 *
 * Question 6: What parameters does the main method define?
 *
 * Answer: Array of String
 *
 *
 * Real-world objects contain ___ and ___. Ans: states and behavior.
 * A software object's state is stored in ___. Ans: fields
 * A software object's behavior is exposed through ___. Ans: methods
 * Hiding internal data from the outside world, and accessing it only through publicly exposed methods
 * is known as data ___. Ans: encapsulation
 * A blueprint for a software object is called a ___. Ans: class
 * Common behavior can be defined in a ___ and inherited into a ___ using the ___ keyword. Ans: superclass, subclass, extends
 * A collection of methods with no implementation is called an ___. Ans: interface
 * A namespace that organizes classes and interfaces by functionality is called a ___. Ans: package
 * The term API stands for ___? Ans: Application Programming Interface
 *
 */

/**
 * The HelloWorld class implements an application that
 * simply displays "Hello World! to the standard output
 */
public class HelloWorld {
     static public void main(String[] args) {
        System.out.println("Hello World!");
    }
}
