package hackerrank.recursion.cci;

/**
 * Print all valid combinations of n pairs of parentheses.
 *
 * E.g : input 3
 * output: ()()(),()(()),(())(),((())),(()()),
 *
 * Created by sharath on 8/17/15.
 */
public class PairsOfParentheses {
    public static void printPar(int n) {
        char[] str = new char[n*2];
        printParR(n, n, str, 0);
    }

    private static void printParR(int l, int r, char[] str, int count) {
        if(l == 0 && r == 0) {
            System.out.println(str);
        }
        else {
            if(l > 0) {
                str[count] = '(';
                printParR(l - 1, r, str, count + 1);
            }
            if(r > l) {
                str[count] = ')';
                printParR(l, r - 1, str, count + 1);
            }
        }
    }

    public static void main(String[] args) {
        printPar(3);
    }
}
