package hackerrank.recursion.homework;

import java.util.Random;

/**
 * Created by sharath on 8/15/15.
 */
public class TOfHanoi {
    public static void computeTowerOfHanoi(int numRings) {
        computeTowerOfHanoi(numRings, 0, 1, 2);
    }

    private static void computeTowerOfHanoi(int numRingsToMove,
                                            int fromPeg, int toPeg, int usePeg) {
        // move n-1 pegs from fromPeg to usePeg using toPeg
        // move nth peg from fromPeg to toPeg
        // move n-1 pegs from usePeg to toPeg using fromPeg
        if(numRingsToMove > 0) {
            computeTowerOfHanoi(numRingsToMove - 1, fromPeg, usePeg, toPeg);
            System.out.printf("Moving ring-%d from peg-%d to peg-%d %n", numRingsToMove,
                    fromPeg, toPeg);
            computeTowerOfHanoi(numRingsToMove - 1, usePeg, toPeg, fromPeg);
        }
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int n = new Random().nextInt(10) + 1;

        System.out.println("n = " + n);

        computeTowerOfHanoi(n);
    }
}
