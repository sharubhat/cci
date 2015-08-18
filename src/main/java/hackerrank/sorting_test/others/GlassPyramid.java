package hackerrank.sorting_test.others;

/**
 * There are some glasses with equal volume 1 litre. The glasses kept as follows
 * 1
 * 2   3
 * 4    5    6
 * 7    8    9   10
 * You can put water to only top glass. If you put more than 1 litre water
 * to 1st glass, water overflow and fill equally both 2nd and 3rd glass.
 * Glass 5 will get water from both 2nd glass and 3rd glass and so on..
 * If you have X litre of water and you put that water in top glass,
 * so tell me how much water contained by jth glass in ith row.
 * <p>
 * Solution : This is Pascal's triangle(check wiki)
 * <p>
 * In this problem the rates at which glasses get filled in are rational numbers,
 * whose numerators form the binomial coefficients and denominators are powers of 2
 * - specifically 2 raised to the power of level at which glasses are present.
 * <p>
 * A litre of water (overflowed from previous level) gets distributed
 * among the glasses at each level as follows:
 * <p>
 * <p>
 * level 0: 1
 * level 1: 1/2  1/2
 * level 2: 1/4  2/4  1/4
 * level 3: 1/8  3/8  3/8  1/8
 * level 4: 1/16  4/16  6/16  4/16  1/16
 * The above distribution pattern provides with a partial progress towards
 * the actual algorithm that finds the amount of water in jth glass of ith row.
 * The algorithm gets tricky because all the glasses at a level
 * might not be completely filled yet, before water starts getting filled up in
 * levels below (albeit, in an inverted triangle fashion).
 * <p>
 * ----------------------------------------------------------------------------
 * The above observation apart, a DP-like algorithm below(that remembers quantities
 * in glasses of the previous row) to find out the amount of water
 * in jth jug of ith row can solve the problem.
 * <p>
 * 0. For each glass, maintain 2 variables - the amount of water it holds and
 * the amount of water it overflows.
 * 1. For a glass at index i in the given row,
 * look up two glasses in the previous row at index i-1 & i.
 * (Boundary cases of indices need to be checked though)
 * 2. The inflow into the current glass
 * = half of outflow of glass in the previous row at i-1
 * + half of outflow of glass in the previous row at index i
 * 3. Based on the inflow, volume held in the current glass
 * = min(1, inflow) and the overflow at the current glass
 * = inflow - volume held by the current glass
 * 4. Repeat steps 1 to 3 until we reach the required glass.
 */

import java.util.Scanner;
import java.util.regex.Pattern;

class GlassStatus {
    float heldVolume;
    float overflownVolume;
}

public class GlassPyramid {

    static int ipRowNum, ipGlassNum, ipVolume;

    public static float computeWaterAt(float volume, int level, GlassStatus[] previousRows) {

        if (volume <= 0)
            return 0;

        GlassStatus[] rows = new GlassStatus[level + 1];
        float overflow1 = 0, overflow2 = 0, inflow = 0, tempVol = 0;

        for (int i = 0, prev = i - 1, next = i; i <= level; i++, prev++, next++) {

            rows[i] = new GlassStatus();

            if (prev < 0) {
                overflow1 = 0;
            } else {
                overflow1 = previousRows[prev].overflownVolume / 2;
            }

            if (next >= level) {
                overflow2 = 0;
            } else {
                overflow2 = previousRows[next].overflownVolume / 2;
            }
            if (level == 0) {
                inflow = volume;
            } else {
                inflow = overflow1 + overflow2;
            }

            tempVol += rows[i].heldVolume = Math.min(1, inflow);
            rows[i].overflownVolume = inflow - rows[i].heldVolume;
        }

        if (level == ipRowNum) {
            return rows[ipGlassNum].heldVolume;
        } else {
            return computeWaterAt(volume - tempVol, level + 1, rows);
        }
    }

    public static void readInput() {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator"));
        Pattern delimiters = Pattern.compile(System.getProperty("line.separator") + "|\\s");
        scanner.useDelimiter(delimiters);

        System.out.println("Input row#:");
        ipRowNum = scanner.nextInt();

        System.out.println("Input glass#:");
        ipGlassNum = scanner.nextInt();

        System.out.println("Input volume:");
        ipVolume = scanner.nextInt();

    }

    public static void main(String[] args) {
        readInput();
        System.out.println("Volume in the glass=" + computeWaterAt(ipVolume, 0, new GlassStatus[]{}));
    }

}