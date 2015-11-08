package hackerrank.arrays_strings_and_everything.epi.stocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Refer to epi problem 6.7
 *
 * Find out the max profit that can be made by buying and selling a stock at max two times.
 *
 * Time complexity : O(n)
 * Space complexity : O(1)
 *
 * Hint: How can you split it to two independent problems?
 *
 * Approach: Going forward gives the max profit that we can make by "selling on i'th day". This can be cached so that,
 * at each day we know what's the max profit we can make. Now we need to find what is the max profit that we can make
 * by "buying on i'th day". This can be achieved by walking backwards. Adding both cached values, we get max profit that
 * can be made by buying and selling twice - once on or before i'th day and once on or after i'th day.
 *
 * Created by sharath on 10/31/15.
 */
public class BuySellAStockTwice {
    public static double maxProfitSellingTwice(List<Double> prices) {
        double maxTotalProfitSoFar = 0.0;
        List<Double> firstBuySellProfits = new ArrayList<>();
        double minPriceSoFar = Double.MAX_VALUE, maxPriceSoFar = Double.MIN_VALUE;

        // walking forward, finding max profit by selling on ith day
        double maxProfit = 0.0;
        for(Double price : prices) {
            minPriceSoFar = Math.min(minPriceSoFar, price);
            maxProfit = Math.max(maxProfit, price - minPriceSoFar);
            firstBuySellProfits.add(maxProfit);
        }

        maxProfit = 0.0;
        // walking backwards, finding max profit by buying on ith day
        // no need to cache here as we only need one value that is max after addition
        for(int i = prices.size() - 1; i > 0; --i) {
            maxPriceSoFar = Math.max(maxPriceSoFar, prices.get(i));
            maxProfit = Math.max(maxProfit, maxPriceSoFar - prices.get(i));
            maxTotalProfitSoFar = Math.max(maxTotalProfitSoFar, maxProfit + firstBuySellProfits.get(i));
        }
        return maxTotalProfitSoFar;
    }

    public static void main(String[] args) {
        Double[] arr = {12.0,11.0,13.0,9.0,12.0,8.0,14.0,13.0,15.0};
        List<Double> list = Arrays.asList(arr);
        System.out.println(maxProfitSellingTwice(list));
    }

}
