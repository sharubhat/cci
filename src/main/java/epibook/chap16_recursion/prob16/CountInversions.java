package epibook.chap16_recursion.prob16;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sharath on 6/28/15.
 */
public class CountInversions {

    private static int countInversions(List<Integer> A) {
        int result = countInversions(A, 0, A.size());
        return result;
    }

    private static int countInversions(List<Integer> A, int start, int end) {
        if(end - start > 1) {
            int mid = start + ((end - start) / 2);
            return countInversions(A, start, mid) +
                    countInversions(A, mid, end) +
                    mergeSortAndCountInversionsAcrossSubarrays(A, start, mid, end);
        }
        return 0;
    }

    private static int mergeSortAndCountInversionsAcrossSubarrays(List<Integer> A, int start, int mid, int end) {
        List<Integer> sortedA = new ArrayList<>();
        int leftIndex = start, rightIndex = mid, inversionCount = 0;

        while(leftIndex < mid && rightIndex < end) {
            if(A.get(leftIndex).compareTo(A.get(rightIndex)) <= 0) {
                sortedA.add(A.get(leftIndex++));
            } else {
                sortedA.add(A.get(rightIndex++));
                inversionCount += mid - leftIndex;
            }
        }

        sortedA.addAll(A.subList(leftIndex, mid));
        sortedA.addAll(A.subList(rightIndex, end));

        for(Integer t : sortedA) {
            A.set(start++, t);
        }
        return inversionCount;
    }

    private static int n2Check(List<Integer> A) {
        int count = 0;
        for (int i = 0; i < A.size(); ++i) {
            for (int j = i + 1; j < A.size(); ++j) {
                if (A.get(i).compareTo(A.get(j)) > 0) {
                    ++count;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        Random r = new Random();
        for (int times = 0; times < 10; ++times) {
            int n;
            if (args.length == 1) {
                n = Integer.parseInt(args[0]);
            } else {
                n = r.nextInt(10) + 1;
            }
            List<Integer> A = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                A.add(r.nextInt(2000001) - 1000000);
            }
            if(n2Check(A) == countInversions(A))
                System.out.println("Cool");
        }
    }
}
