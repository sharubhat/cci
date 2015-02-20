package c09_recursion_and_dp.recursion;

/**
 * Recursive binary search
 * Created by sharath on 9/9/14.
 */
public class BinarySearch {
    public int binarySearch(Object[] items, Comparable target) {
        return binarySearch(items, target, 0, items.length);
    }

    @SuppressWarnings("unchecked")
    private int binarySearch(Object[] items, Comparable target, int first, int last) {
        if(first > last)
            return -1;
        else {
            int middle = (first + last) / 2;
            int compResult = target.compareTo(items[middle]);
            if(compResult == 0)
                return compResult;
            else if(compResult < 0) {
                return binarySearch(items, target, first, middle - 1);
            } else {
                return binarySearch(items, target, middle + 1, last);
            }
        }
    }
}
