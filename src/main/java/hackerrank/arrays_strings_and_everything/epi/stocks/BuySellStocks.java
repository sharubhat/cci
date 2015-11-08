package hackerrank.arrays_strings_and_everything.epi.stocks;

import java.util.Arrays;
import java.util.List;

/**
 * Refer to epi problem 6.7
 * 
 * In simple words, given an array of positive numbers, find two numbers whose difference is the max, with a condition
 * that smaller number should appear first, i.e. stock should be bought at lesser price and sold at higher price to
 * make profit.
 *
 * Time complexity : O(n)
 * Space complexity : O(1)
 * 
 * Created by sharath on 10/31/15.
 */
public class BuySellStocks {

    public static void main(String[] args) {
        Double[] arr = {310.0,315.0,275.0,295.0,260.0,270.0,290.0,230.0,255.0,250.0};
        List<Double> list = Arrays.asList(arr);
        System.out.println(maxProfit(list));
    }

    private static double maxProfit(List<Double> prices) {
        double minPrice = Double.MAX_VALUE, maxProfit = 0.0;
        for(Double price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }
}
