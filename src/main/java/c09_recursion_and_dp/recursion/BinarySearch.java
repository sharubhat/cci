package c09_recursion_and_dp.recursion;

/**
 * Recursive binary search
 * Created by sharath on 9/9/14.
 */
public class BinarySearch<V extends Comparable<V>> {
    public int binarySearch(V[] items, V target) {
        return binarySearch(items, target, 0, items.length);
    }

    private int binarySearch(V[] items, V target, int first, int last) {
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
