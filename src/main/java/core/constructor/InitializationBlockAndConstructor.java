package core.constructor;

/**
 * Created by sharath on 7/6/15.
 */
public class InitializationBlockAndConstructor {
    // Initialization block is called for every instance of the class
    // and is always called before the constructor
    {
        System.out.println("Initialization block");
    }

    // Called the first time the class is ever referenced and is called only once.
    // Always called in the order of occurrence.
    // Java runtime guarantees that the static block is called in thread safe manner.
    static {
        System.out.println("Static block");
    }

    static {
        System.out.println("Static block 2");
    }

    public InitializationBlockAndConstructor() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        InitializationBlockAndConstructor c1 = new InitializationBlockAndConstructor();
        InitializationBlockAndConstructor c2 = new InitializationBlockAndConstructor();
    }
}
