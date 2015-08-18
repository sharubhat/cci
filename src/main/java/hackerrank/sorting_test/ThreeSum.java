package hackerrank.sorting_test;

import java.util.*;

/**
 * Created by sharath on 8/10/15.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 3, 5, 7, 8, 9};
        int[] numbersWithDuplicates = {2, 4, 3, 5, 6, -2, 4, 7, 8, 9};
        System.out.println(Arrays.toString(find_triplets(numbers)));
        System.out.println(Arrays.toString(find_triplets(numbersWithDuplicates)));
    }

    public static String[] find_triplets(int[] intArr) {
        Arrays.sort(intArr);
        List triplets = new ArrayList();
        int[] triplet = new int[3];
        int n = intArr.length;
        for (int i = 0;i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum_two = intArr[i] + intArr[j];
                if (sum_two + intArr[k] < 0) {
                    j++;
                } else if (sum_two + intArr[k] > 0) {
                    k--;
                } else {
                    triplet[0] = intArr[i];
                    triplet[1] = intArr[j];
                    triplet[2] = intArr[k];
                    triplets.add(triplet);
                    j++;
                    k--;
                }
            }
        }

        String[] res = new String[triplets.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = Arrays.toString((int[])triplets.get(i));
        }
        return res;
    }

    public static String[] threeSum(int[] intArr) {
        if(intArr.length < 3)
            return null;

        Arrays.sort(intArr);
        List<String> result = new ArrayList<>();

        for(int i = 0; i < intArr.length; i++) {
            if(i == 0 || intArr[i] > intArr[i - 1]) {
                int k = -intArr[i];
                int left = 0;
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
