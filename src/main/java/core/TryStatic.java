package core;

/**
 * Created by sharath on 3/22/15.
 *
 * Only inner class can be static.
 * Fields can be static. There will be only one static field per class and can be accessed by any object of the same class.
 * Methods can be static. They can be invoked on the class or object of that class.
 */
public class TryStatic {
    public static int x;
    private static int y;

    public static void main(String[] args) {

    }
}
class Doit {

    public void method() {
        TryStatic.main(new String[2]);
        int y = TryStatic.x;
        // This is compile time error. Static variable is private.
        // int z = TryStatic.y;
    }
}
