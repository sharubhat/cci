package epibook.chap16_recursion.prob1;

import java.util.Random;

/**
 * Unless someone insists solving this problem using stacks, stick to simple recursion and printing the steps.
 * Created by sharath on 6/28/15.
 */
public class TowerOfHanoi {
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

    public static void main(String[] args) {
        int n;
        if(args.length == 1) {
            n = Integer.parseInt(args[0]);
        } else {
            n = new Random().nextInt(10) + 1;
        }
        System.out.println("n = " + n);

        computeTowerOfHanoi(n);
    }
}
