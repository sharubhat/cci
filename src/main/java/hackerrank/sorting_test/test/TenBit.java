package hackerrank.sorting_test.test;

import java.util.*;

/**
 * Created by sharath on 8/11/15.
 */
public class TenBit {
    public static void main(String[] args) {
        int[] arr = {10, 2, 5, 8, 30};
        char[] objs = {'x', 'a', 'c', 'l', 'k'};

        System.out.println(Arrays.toString(sort(arr, objs)));
    }

    private static char[] sort(int[] arr, char[] objs) {
        char[] result = new char[objs.length];
        Map<Integer, ArrayList<Character>> store = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(store.containsKey(arr[i])) {
                store.get(arr[i]).add(objs[i]);
            } else {
                ArrayList<Character> list = new ArrayList<>();
                list.add(objs[i]);
                store.put(arr[i], list);
            }
        }

        int resultIndex = 0;
        for(int i = 0; i < 1023; i++) {
            if(store.containsKey(i)) {
                ArrayList<Character> list = store.get(i);
                for(Character c : list) {
                    result[resultIndex++] = c;
                }
            }
        }

        return result;
    }
}
