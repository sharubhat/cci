package hackerrank.sorting_test.extra;

import java.util.*;

/**
 * You are given a n X m matrix M. You need to answer Q queries,
 * each consisting of four integers R1,C1,R2,C2.
 * The proper response to a query is the median element within the sub-matrix that consists M(i,j) where
 * R1 <= i <= R2 and C1 <= j <= C2.
 *
 * If the number of elements in the sub-matrix is odd, then the median is defined as the middle number of the
 * sorted list of numbers.
 * If the count is even, then the median is defined as the average of the two middle numbers in the sorted list of numbers,
 * rounded down to nearest integer.
 *
 *
 * Created by sharath on 8/12/15.
 */
public class SubMatrixMedian {

    public static class RandomizedSelection {

        public int search(int nth, int[] inputs) {
            if(inputs == null || inputs.length < nth)
                throw new IllegalArgumentException();

            int k = nth - 1;

            int from = 0, to = inputs.length - 1;

            // if from == to, we have reached nth element
            while(from < to) {
                int r = from, w = to;
                int mid = inputs[(r + w)/2];

                // stop if the reader and writer meet
                while(r < w) {
                    if(inputs[r] >= mid) { // put the large values at the end
                        swap(inputs, r, w);
                        w--;
                    } else {                            // the value is smaller than the pivot, skip
                        r++;
                    }
                }

                // if we stepped up(r++) we need to step one down
                if(inputs[r] > mid) {
                    r--;
                }

                // the r pointer is on the end of the first n elements
                if(k <= r) {
                    to = r;
                } else {
                    from = r + 1;
                }
            }
            return inputs[k];
        }

        private void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        int Q = scan.nextInt();
        int[][] sub = new int[Q][4];
        for(int i = 0; i < Q; i++) {
            for(int j = 0; j < 4; j++) {
                sub[i][j] = scan.nextInt();
            }
        }

        int[] result = answer(matrix, sub);
        for(int i : result) {
            System.out.println(i);
        }
    }

    public static int[] answer(int[][] matrix, int[][] sub) {
        int[] result = new int[sub.length];
        for(int q = 0; q < sub.length; q++) {
            int R1 = sub[q][0];
            int C1 = sub[q][1];
            int R2 = sub[q][2];
            int C2 = sub[q][3];

            int finalSize = (R2 - R1 + 1) * (C2 - C1 + 1);

            int[] qSol = new int[finalSize];
            int index = 0;

            for(int i = R1 - 1; i <= R2 - 1; i++) {
                for(int j = C1 - 1; j <= C2 - 1; j++) {
                    qSol[index++] = matrix[i][j];
                }
            }

            RandomizedSelection randomizedSelection = new RandomizedSelection();
            int median;
            if(finalSize % 2 == 0) {
                median = (randomizedSelection.search(finalSize / 2, qSol) + randomizedSelection.search((finalSize / 2) + 1, qSol))/2;
            } else {
                median = randomizedSelection.search((finalSize / 2) + 1, qSol);
            }
            result[q] = median;
        }
        return result;
    }
}
