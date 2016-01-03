package hackerrank.sorting_test;

import java.util.Arrays;

/**
 * Created by sharath on 8/5/15.
 */
public class NutsNBolts {
    public static void main(String[] args)
    {
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};

        matchPairs(nuts, bolts, 0, 5);

        System.out.println(Arrays.toString(nuts));
        System.out.println(Arrays.toString(bolts));
    }

    private static void matchPairs(char[] nuts, char[] bolts, int low, int high) {
        if(low < high) {
            // use the first bolt to compare and find the nuts that are smaller or lager than the one that fits.
            // partition the nuts such that every nut smaller than the one that fits are to it's left and rest to it's right.
            // Use this position as pivot for partitioning the bolts.
            int pivotIndex = partitionAndReturnPivotIndex(nuts, low, high, bolts[low]);
            partitionAndReturnPivotIndex(bolts, low, high, nuts[pivotIndex]);

            matchPairs(nuts, bolts, low, pivotIndex - 1);
            matchPairs(nuts, bolts, pivotIndex + 1, high);
        }
    }

    private static int partitionAndReturnPivotIndex(char[] arr, int low, int high, char pivot) {
        int i = low;
        for (int curr = low; curr < high; curr++)
        {
            if (arr[curr] < pivot){
                swap(arr, i, curr);
                i++;
            } else if(arr[curr] == pivot){
                // this partitioning routine varies slightly from quick sort partitioning in the fact that
                // pivot is not chosen from current array but is supplied. So, instead of remembering
                // the position where the match is found, simply move it to the end.
                swap(arr, curr, high);
                curr--;
            }
        }
        // at this point, because the problem states that there is one and only one perfect match for pivot,
        // it must be the last element in the array. Place it at it's rightful position.
        swap(arr, i, high);
        return i;
    }

    private static void swap(char[] in, int i1, int i2) {
        char tmp = in[i1];
        in[i1] = in[i2];
        in[i2] = tmp;
    }
}
