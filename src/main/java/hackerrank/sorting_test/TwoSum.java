package hackerrank.sorting_test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find any two numbers within the given array that sum to a number k.
 *
 * Hint: Sort the numbers first. Start by adding left most number and right most number.
 * If the sum is equal to k, print the numbers. Else, depending on the sum, increment left or decrement right.
 * Note: This approach assumes there are no duplicates.
 *
 * Created by sharath on 8/10/15.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 3, 5, 7, 8, 9};
        int[] numbersWithDuplicates = {2, 4, 3, 5, 6, -2, 4, 7, 8, 9};
        printBySorting(numbers, 7);
        System.out.println();
        twoSum(numbers, 7);

        System.out.println();
        System.out.println();
        printBySorting(numbersWithDuplicates, 7);
        System.out.println();
        twoSum(numbersWithDuplicates, 7);
    }

    public static void printBySorting(int[] numbers, int k) {
        if (numbers.length < 2) {
            return;
        }
        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == k) {
                System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
                left = left + 1;
                right = right - 1;
            } else if (sum < k) {
                left = left + 1;
            } else if (sum > k) {
                right = right - 1;
            }
        }
    }

    public static void twoSum(int[] num, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < num.length; i++) {
            map.put(k - num[i], i);
        }

        for(int i = 0; i < num.length; i++) {
            if(map.containsKey(num[i])) {
                if(map.get(num[i]) != i) {
                    System.out.printf("(%d, %d) %n", num[i], num[map.get(num[i])]);
                    // need to find a better way. It's hard to remember to clean up the dupes.
                    map.remove(num[map.get(num[i])]);
                }
            }
        }
    }
}
