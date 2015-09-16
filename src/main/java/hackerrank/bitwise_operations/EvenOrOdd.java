package hackerrank.bitwise_operations;

/**
 * Created by sharath on 6/27/15.
 */
public class EvenOrOdd {
    public static void main(String[] args) {
        int x = Integer.parseInt("00101010", 2);

        if((x & 1) == 0) {
            System.out.println("Number " + x + " is even");
        } else {
            System.out.println("Number " + x + " is odd");
        }
    }
}
