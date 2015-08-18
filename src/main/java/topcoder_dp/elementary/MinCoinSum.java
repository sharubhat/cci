package topcoder_dp.elementary;

import java.util.Arrays;

/**
 * Created by sharath on 2/11/15.
 * Refer to topcoder tutorial for details
 */
public class MinCoinSum {
    public static void main(String[] args) {
        int[] coins = {3, 5};
        int sum = 15;
        calculateMin(coins, sum);
        calcMin(coins, sum);
    }

    // solution where to find sum[n] you find out coins needed for sum[m<n] and each coin in coins.
    // that would be min of coins for (sum[m1] + 1) or (sum[m2] + 1) etc - done for as many number of coins present
    private static void calculateMin(int[] coins, int sum) {
        // create a store. remember that you would be storing sum 0, so size is sum + 1.
        int[] store = new int[sum + 1];
        // except for sum 0 which is default 0, set everything to positive infinity
        // This is required. Else 0 which is default will be considered as minimum coins needed.
        Arrays.fill(store, 1, store.length, Integer.MAX_VALUE);
        // we need to start summing from 0.
        // here is what happens. For every sum N, we check the max coin + already calculated sum that can result in N.
        // Since already calculated sum has min required coins m, N would need m+1 coins.
        for (int currSum = 0; currSum <= sum; currSum++) {
            for(int coinValue : coins) {
                if (coinValue <= currSum && store[currSum - coinValue] < store[currSum]) {
                    store[currSum] = store[currSum - coinValue] + 1;
                }
            }
        }
        // print carefully. The sum which can not be achieved will be printed as infinity which is not correct.
        for (int i : store) {
            int value = Integer.MAX_VALUE == i ? 0 : i;
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // another approach. Set sum 0  to 0. Every iteration starts from sum 1 and considering each coin at a time.
    // See if you can add coin to sum[m] and update min coin for sum[n] which can be achieved by sum[m] + coin[i] -> n = m+coins[i]

    // TODO: The code has a bug, needs a fix.
    private static void calcMin(int[] coins, int sum) {
        int min[] = new int[sum + 1];
        Arrays.fill(min, 1, min.length, Integer.MAX_VALUE);
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j + coins[i] <= sum; j++) {
                if(min[j] == Integer.MAX_VALUE && j < coins[i]) {
                    min[j] = 0;
                } else {
                    if (j + coins[i] < sum) {
                        int minN = min[j + coins[i]];
                        int newMin = min[j] + 1;
                        if (minN > newMin) {
                            min[j + coins[i]] = newMin;
                        }
                    }
                }
            }
        }
        for (int i : min) {
            int value = Integer.MAX_VALUE == i ? 0 : i;
            System.out.print(value + " ");
        }
    }
}