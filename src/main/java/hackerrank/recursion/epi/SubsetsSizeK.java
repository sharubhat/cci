package hackerrank.recursion.epi;

import java.util.*;

/**
 * Generate all subsets of size k of a set {1,2,3.....n} where k and n are program inputs.
 * 
 * e.g: If k = 2 and n = 5, then result is:
 * {{1,2},{1,3},{1,4},{1,5},{2,3},{2,4},{2,5},{3,4},{3,5},{4,5}}
 * 
 * Brute force approach is to generate power set and select on the sets that are of size k. This is inefficient.
 * To increase the efficiency we could make use of case analysis.
 * There are two possibilities of subset. One that does not contain 1 and other that does.
 * In the first case we find all subsets of size k for the set {2,3,...n} and for second case, we find all subsets of
 * size k-1 and add 1 to each of them. Result is going to be union of both these sets.
 * 
 * Created by sharath on 9/30/15.
 */
public class SubsetsSizeK {
//    private static List<List<Integer>> subsetsSizeK(Set<Integer> set, int k) {
//        List<List<Integer>> result = new ArrayList<>();
//        subsetsSizeKRec(new ArrayList<>(set), k, result);
//        return result;
//    }

    private static void print(int[] array, boolean[] used, int startIndex, int currentSize, int k) {
        if(currentSize == k) {
            System.out.println(Arrays.toString(used));
            for(int i = 0; i < array.length; i++) {
                if(used[i])
                    System.out.print(array[i] + " ");
            }
            System.out.println();
            return;
        }
        if(startIndex == array.length)
            return;
        used[startIndex] = true;
        print(array, used, startIndex + 1, currentSize + 1, k);
        used[startIndex] = false;
        print(array, used, startIndex + 1, currentSize, k);
    }

//    private static List<List<Integer>> subsetsSizeKRec(List<Integer> list, int k, List<List<Integer>> result) {
//        if (k == 0) {
//            return Collections.emptyList();
//        }
//        if (k == list.size()) {
//            result.add(list);
//            return list;
//        }
//        List<List<Integer>> currentList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            Integer head = list.get(i);
//            List<Integer> rest = new ArrayList<>(list);
//            rest.remove(i);
//            List<List<Integer>> inclusionList = subsetsSizeKRec(rest, k, result);
//            List<List<Integer>> exclusionList = subsetsSizeKRec(rest, k - 1, result);
//            if (exclusionList.isEmpty())
//                exclusionList = new ArrayList<>();
//            for(List<Integer> each : exclusionList) {
//                each.add(head);
//            }
//            currentList.addAll(exclusionList);
//            currentList.addAll(inclusionList);
//        }
//        return currentList;
//    }

    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 1; i < 6; i++) {
//            set.add(i);
//        }
//        List<List<Integer>> result = subsetsSizeK(set, 2);
//        System.out.println(result);
        int[] array = {1,2,3,4,5};
        int k = 2;
        boolean[] used = new boolean[array.length];
        print(array, used, 0, 0, 2);
    }
}
