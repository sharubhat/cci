package hackerrank.sorting_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Given an array of positive numbers, group them to be odd and even. Output need not be sorted, but the
 * grouping should happen in place.
 *
 * Created by sharath on 1/2/16.
 */
public class GroupTheNumbers {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> nums = new ArrayList<>();
        int size = rand.nextInt(100);
        for(int i = 0; i < size; i++) {
            nums.add(rand.nextInt(100));
        }
        System.out.println(nums);
        new GroupTheNumbers().group(nums);
        System.out.println(nums);
    }

    public void group(List<Integer> nums) {
        int k = -1;
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) % 2 == 0) {
                k++;
                swap(nums, k, i);
            }
        }
    }

    private void swap(List<Integer> nums, int i, int j) {
        int num = nums.get(j);
        nums.set(j, nums.get(i));
        nums.set(i, num);
    }
}

