package hackerrank.dynamic_programming.zenefits;

import java.util.*;

/**
 * Given an array of integers with zeros and ones,
 * and that you can do one single operation to flip bits from index k to l inclusive (contiguous),
 * calculate the maximum bits that will be set at the end of flip operation.
 *
 * E.g :
 * flip[1,5] on 1,0,0,1,0,0,1,0 gives 1,1,1,0,1,1,1,0 Ans :6
 * flip[1,7] on same data set gives 1,1,1,0,1,1,0,1 Ans :6
 *
 * Created by sharath on 10/12/15.
 */
public class FlipBits {
    public static void main(String[] args) {
        List<Integer[]> entries = new ArrayList();
        Integer[] input = {1,0,0,1,0,0,1,0};
        Integer[] input1 = {0,0,1};
        Integer[] input2 = {1,1,1,0,0,0,1,1,1,1,0,0,1,0,0,1};
        Integer[] input3 = {1,1,1,0};
        entries.add(input);
        entries.add(input1);
        entries.add(input2);
        entries.add(input3);

        for(Integer[] in : entries) {
            System.out.println(bitFlip1(in));
        }
    }

    // there is an optimization possible with bitFlip. Instead of using an array for storage,
    // we could use two variables as we are only concerned about the max.
    static int bitFlip1(Integer[] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        int currentMax = 0;
        int setBits = 0;
        if(arr[0] == 0)
            currentMax = 1;

        int maxSoFar = currentMax;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == 0) {
                currentMax = currentMax + 1;
            } else {
                currentMax = currentMax == 0 ? 0 : currentMax - 1;
                setBits++;
            }
            if(currentMax > maxSoFar)
                maxSoFar = currentMax;
        }

        return setBits + maxSoFar;
    }

    static int bitFlip(Integer[] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        int[] count = new int[arr.length];
        if(arr[0] == 0)
            count[0] = 1;
        else
            count[0] = 0;


        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == 0) {
                count[i] = count[i-1] + 1;
            } else {
                count[i] = count[i-1] == 0 ? 0 : count[i-1] - 1;
            }
        }

        // flippableBits contains the max number of set bits that we can get starting from zero.
        // that means, in the below example, there are 5 zeros that will convert to ones. Any remaining 0's and 1's
        // in between count 0 and 5 will get nullified. So, to calculate total number of set bits, we can either add
        // max 1's count we can get and existing 1's OR flip all bits between count 0 and the max and then count total
        // number of 1's.
        // e.g:
        //   0 0 0 1 1 0 0 0 0 1 becomes
        //   1 1 1 0 0 1 1 1 1 1 with counts being
        // 0 1 2 3 2 1 2 3 4 5 4
        int flippableBits = 0;
        for(int i = 1; i < count.length; i++) {
            if (count[i] > flippableBits) {
                flippableBits = count[i];
            }
        }

        int setBits = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                setBits++;
            }
        }

        return setBits + flippableBits;
    }
}
