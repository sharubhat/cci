package string.any;

/**
 * Sort characters in a string without library method
 *
 * Created by sharath on 3/1/15.
 */
public class Sort {
    public static void main(String[] args) {
        System.out.println("Ans is : '" + sort(" ".toCharArray()) + "'");
    }

    public static String sort(String input) {
        return sort(input.toCharArray());
    }


    public static String sort(char[] chars) {
        char[] helper = new char[chars.length];
        mergesort(0, chars.length - 1, chars, helper);
        return new String(chars);
    }

    private static void mergesort(int low, int high, char[] chars, char[] helper) {
        // Check if low is smaller then high, if not then the array is sorted
        if(low < high) {
            int mid = low + (high - low)/2;

            mergesort(low, mid, chars, helper);
            mergesort(mid + 1, high, chars, helper);
            merge(low, mid, high, chars, helper);
        }
    }

    private static void merge(int low, int mid, int high, char[] chars, char[] helper) {
        // Copy part of numbers to be sorted into the helper array
        for(int i = low; i <= high; i++) {
            helper[i] = chars[i];
        }

        int li = low;
        int ri = mid + 1;
        int di = low;

        // Copy the smallest values from either the left or the right side back
        // to the original array
        while(li <= mid && ri <= high) {
            if(helper[li] <= helper[ri]) {
                chars[di++] = helper[li++];
            }
            else {
                chars[di++] = helper[ri++];
            }
        }

        // Copy the rest of the left side of the array into the target array
        // Node that since helper is copy of numbers and
        // right side is already sorted, we need not copy them again
        while(li <= mid) {
            chars[di++] = helper[li++];
        }

    }
}
