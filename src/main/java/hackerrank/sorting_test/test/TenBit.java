package hackerrank.sorting_test.test;

import java.util.*;

/**
 * You are given approximately 10 million pairs. Each pair consists of a 10-bit integer and an object.
 * Implement an efficient sorting algorithm to sort the objects. Sort order of the objects is determined by its paired integer.
 *
 * Inputs:
 * 1. First array, of numbers, size N
 * 2. Second array, of Objects, size N (assume 1-1 correlation)
 *
 * Hint : 10-bit integer can have a max value of 1023. There are 10 million such pairs which means there are dupes.
 * Should we preserve the original order in case of duplicate numbers?
 *
 * Created by sharath on 8/11/15.
 */
public class TenBit {
    public static void main(String[] args) {
        int[] arr = {10, 2, 2, 5, 8, 30};
        String[] objs = {"10x", "2a", "2k", "5c", "8l", "30k"};

        System.out.println(Arrays.toString(sort(arr, objs)));
    }

    private static String[] sort(int[] arr, String[] objs) {
        String[] result = new String[objs.length];
        // since there are duplicates, create a map to put duplicates together
        Map<Integer, ArrayList<String>> store = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(store.containsKey(arr[i])) {
                store.get(arr[i]).add(objs[i]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(objs[i]);
                store.put(arr[i], list);
            }
        }

        int resultIndex = 0;
        // an unsigned integer containing 10 bits can have a value between 0 and 2^10 - 1 = 1024
        for(int i = 0; i < 1024; i++) {
            if(store.containsKey(i)) {
                ArrayList<String> list = store.get(i);
                for(String c : list) {
                    result[resultIndex++] = c;
                }
            }
        }

        return result;
    }
}
