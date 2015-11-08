package hackerrank.arrays_strings_and_everything.epi.permutations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Write a program that takes an input which is a random permutation of array index and gives the next smallest
 * permutation which these indices are arranged in the dictionary order.
 *
 * E.g: Given {2,5,4,3}, when n! permutations are arranged in dictionary order, {3,2,4,5} is the smallest possible
 * permutation that is larger than given.
 *
 * If given permutation is {5,4,3,2} then it itself is the last permutation in the dictionary order, return {}
 *
 * Solution:
 * Consider example {6,2,1,5,4,3,0}. Finding next number means replacing right most smallest number with a larger
 * number available to it's right. But this would result in a number smaller than current.
 * Further observation shows, instead of changing the right most, swapping the first smallest number that we encounter
 * after an increasing sub-array from right would result in a larger number. It should be swapped with the first largest
 * number in the right sub-array.
 * This gives {6,2,[3],5,4,[1],0}. You will soon notice that it's larger than given permutation but it's not the
 * smallest permutation greater than given array. This can be achieved by sorting the right sub-array.
 * Result : {6,2,3,0,1,4,5}
 *
 * You will also notice that after first swap, the right sub-array will still be reverse sorted. This means we need not
 * use a sorting utility that takes O(nlogn), instead simply reverse the sub-array.
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 *
 * Created by sharath on 11/1/15.
 */
public class NextSmallestPermutation {
    public static List<Integer> nextSmallestPermutation(List<Integer> permute) {
        int k = permute.size() - 2;     // index to first smallest entry other than right most entry
        while(k >= 0 && permute.get(k + 1) <= permute.get(k)) {
            k--;
        }
        if(k == -1) {
            return Collections.emptyList();
        }

        for(int i = permute.size() - 1; i >= 0; i--) {
            if(permute.get(i) > permute.get(k)) {
                Collections.swap(permute, k, i);
                break;
            }
        }

        Collections.reverse(permute.subList(k+1, permute.size()));

        return permute;
    }

    public static void main(String[] args) {
        System.out.println(nextSmallestPermutation(Arrays.asList(new Integer[]{6,2,1,5,4,3,0})));
    }
}
