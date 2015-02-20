package c09_recursion_and_dp.recursion;

/**
 * Created by sharath on 8/20/14.
 *
 * Problem description:
 * Classic problem of tower of Hanoi.
 * You have 3 towers and N disks of different sizes.
 * Disks can slide onto any towers.
 * Puzzle starts with disks in ascending order from top to bottom on tower 1.
 * Following are the constraints
 * 1. Only one disk can be moved at a time.
 * 2. A disk is slid off the top of one tower onto next.
 * 3. A disk can only be placed on top of larger disk.
 *
 * Write a program to print move all disks from tower 1 to 3 using recursion.
 */
public class Tower {
    public String hanoi(int nDisks, int fromT, int toT) {
        int helpT;
        if(nDisks == 1) {
            return "Do this move : " + fromT + " --> " + toT + "\n";
        } else {
            // Determine helpT(fromT + helpT + toT = 6)
            helpT = 6 - fromT - toT;

            // Solve this for smaller sub problem
            String sol1 = hanoi(nDisks - 1, fromT, helpT);
            String myStep = "Do this move : " + fromT + " --> " + toT + "\n";
            String sol2 = hanoi(nDisks - 1, helpT, toT);

            return sol1 + myStep + sol2;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        String stepsToSolution = new Tower().hanoi(n, 1, 3);
        System.out.println(stepsToSolution);
    }
}
