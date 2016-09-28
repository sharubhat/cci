package hackerrank.sorting_test;

import java.util.*;

/**
 * Given an array of N integers, find all triplets that sum to a given integer 0.
 * Triples may not be consecutive.
 * Array can include duplicates.
 * Array is not necessarily sorted.
 *
 * Created by sharath on 8/10/15.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 3, 5, 7, 8, 9};
        int[] numbersWithDuplicates = {2, 4, 3, 5, 6, -2, 4, -8, 7, 8, 9};
        System.out.println(Arrays.toString(threeSum(numbers)));
        System.out.println(Arrays.toString(threeSum(numbersWithDuplicates)));
    }

    public static String[] threeSum(int[] intArr) {
        if(intArr.length < 3)
            return null;

        Arrays.sort(intArr);
        List<String> result = new ArrayList<>();

        for(int i = 0; i < intArr.length; i++) {
            if(i == 0 || intArr[i] > intArr[i - 1]) {
                int k = -intArr[i];
                int left = i + 1;
                int right = intArr.length - 1;
                while(left < right) {
                    int sum = intArr[left] + intArr[right];
                    if(sum == k) {
                        result.add(intArr[left] + "," + intArr[right] + "," + (-k));
                        left++;
                        right--;
                        while (left < right && intArr[right] == intArr[right + 1])
                            right--;

                        while (left < right && intArr[left] == intArr[left - 1])
                            left++;
                    } else if(sum < k) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        String[] res = new String[result.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
