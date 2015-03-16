package assert_example;

/**
 * Created by sharath on 3/15/15.
 * adding '-ea' as vm argument runs the program with assertion enabled.
 */
public class AssertExample {
    public static void main(String[] args) {
        int x = 2;

        if(x == 0)
            System.out.println("X is zero");
        else {
            assert x == 1 : x;  // x is either 0 or 1
            System.out.println("X is " + x);
        }
    }
}
