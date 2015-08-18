package hackerrank.recursion.homework;

/**
 * Created by sharath on 8/15/15.
 */
public class Wildcard {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        wildcard("10?");
        System.out.println();
        wildcard("1?0?");
    }

    public static void wildcard(String str) {
        wildcardR(str, 0);
    }

    private static void wildcardR(String s, int n) {
        if(n == s.length() - 1) {
            if(s.charAt(n) == '?') {
                System.out.print(s.substring(0, n) + '0' + " ");
                System.out.print(s.substring(0, n) + '1' + " ");
            }
        } else {
            if(s.charAt(n) == '?') {
                wildcardR(s.substring(0, n) + '0' + s.substring(n + 1), n + 1);
                wildcardR(s.substring(0, n) + '1' + s.substring(n + 1), n + 1);
            } else {
                wildcardR(s, n + 1);
            }
        }
    }
}
