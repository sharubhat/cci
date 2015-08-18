package hackerrank.sorting_test.others;

import java.util.*;
import java.util.Map.Entry;

/**
 * Given an array of integers . Write an algorithm to find all the Pythagorean triples.
 * Eg : i/p : int arr[ ] = {1,3,4,5,6,7,8,10,11}
 * o/p: Print 3,4,5 and 6,8,10

 * Created by sharath on 8/14/15.
 */
public class FindingPythagoreanTriplets {
    public static void main(String[] args) {
        int arr[ ] = {1,3,4,5,6,7,8,10,11};

        FindingPythagoreanTriplets pTriplets = new FindingPythagoreanTriplets();
        pTriplets.printTriplets(arr);
    }

    public void printTriplets(int[] arr) {

        Map<Integer, Integer> store = createSquares(arr);

        for(int i=0; i< arr.length ; i++) {
            for(int j=i+1; j< arr.length; j++) {
                int sum = store.get(arr[i]) + store.get(arr[j]);
                if(store.containsValue(sum)) {
                    int key = findValueForKey(store, sum);
                    System.out.println(arr[i] + ", " + arr[j] + ", " + key);
                    System.out.println();
                }
            }
        }

    }

    private Integer findValueForKey(Map<Integer, Integer> store, int value) {
        Set<Entry<Integer, Integer>> entries = store.entrySet();
        for(Entry<Integer, Integer> e : entries) {
            if(e.getValue() == value)
                return e.getKey();
        }
        return null;
    }

    private Map<Integer, Integer> createSquares(int[] arr) {
        Map<Integer, Integer> store = new HashMap<Integer, Integer>();
        for(int i = 0; i< arr.length; i++) {
            if(!store.containsKey(arr[i])) {
                store.put(arr[i], square(arr[i]));
            }
        }
        return store;
    }

    private int square(int i) {
        return i*i;
    }
}
