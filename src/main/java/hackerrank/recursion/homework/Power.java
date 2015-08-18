package hackerrank.recursion.homework;

/**
 * Created by sharath on 8/16/15.
 */
public class Power {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        System.out.println(pow(3, 2));
        System.out.println(pow(3, 0));
        System.out.println(pow(5, -3));
        System.out.println(Math.pow(5, -3));

    }

    public static double pow(double d, int p) {
        if(p == 0)
            return 1;
        else if(p > 0) {
            return d * pow(d, p - 1);
        } else {
            return 1/ pow(d, -p);
        }
    }
}
