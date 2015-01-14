package elements.of.programming.interviews;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by sharath on 1/7/15.
 *
 * Problem 6.3
 * In short, this is simply calculating difference between the largest and smallest value in an array
 */
public class RobotBattery_6_3 {
    public static int findBatteryCapacity(int[] h) {
        int minHeight = Integer.MAX_VALUE, capacity = 0;
        for(int height : h) {
            capacity = max(capacity, height - minHeight);
            minHeight = min(minHeight, height);
        }
        return capacity;
    }

    public static void main(String[] args) {
        Random gen = new Random();
        for (int times = 0; times < 1; ++times) {
            int n;
            if (args.length == 1) {
                n = Integer.valueOf(args[0]);
            } else {
                n = gen.nextInt(20) + 1;
            }
            int[] A = new int[n];
            for (int i = 0; i < n; ++i) {
                A[i] = nextPositiveInt(gen, n);
            }
            int[] A1 = {2, 8, 7, 4, 8, 3, 3, 2, 4, 14, 8, 11, 1, 8, 3};
            System.out.println(Arrays.toString(A1));
            System.out.println(findBatteryCapacity(A1));
            System.out.println(checkAns(A1));

            System.out.println(Arrays.toString(A));
            System.out.println(findBatteryCapacity(A));
            System.out.println(checkAns(A));
            assert (checkAns(A) == findBatteryCapacity(A));
        }
    }

    // O(n^2) checking answer.
    private static int checkAns(int[] h) {
        int cap = 0;
        for (int i = 1; i < h.length; ++i) {
            for (int j = 0; j < i; ++j) {
                cap = max(cap, h[i] - h[j]);
            }
        }
        return cap;
    }

    private static Integer nextPositiveInt(Random random, int maxValue) {
        int next = random.nextInt(maxValue);
        return next == Integer.MIN_VALUE ? Integer.MAX_VALUE : next;
    }
}
