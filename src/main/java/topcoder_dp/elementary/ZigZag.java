package topcoder_dp.elementary;

/**
 * Created by sharath on 2/12/15.
 * Topcoder problem
 *
 * Problem Statement

 A sequence of numbers is called a zig-zag sequence if the differences between successive numbers strictly alternate
 between positive and negative. The first difference (if one exists) may be either positive or negative.
 A sequence with fewer than two elements is trivially a zig-zag sequence.

 For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) are alternately positive and negative.
 In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag sequences, the first because its first two differences are positive
 and the second because its last difference is zero.

 Given a sequence of integers, sequence, return the length of the longest sub-sequence of sequence that is a zig-zag sequence.
 A sub-sequence is obtained by deleting some number of elements (possibly zero) from the original sequence,
 leaving the remaining elements in their original order.


 Definition

 Class:	ZigZag
 Method:	longestZigZag
 Parameters:	int[]
 Returns:	int
 Method signature:	int longestZigZag(int[] sequence)
 (be sure your method is public)


 Constraints
 -	sequence contains between 1 and 50 elements, inclusive.
 -	Each element of sequence is between 1 and 1000, inclusive.

 Examples
 0)

 { 1, 7, 4, 9, 2, 5 }
 Returns: 6
 The entire sequence is a zig-zag sequence.
 1)

 { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }
 Returns: 7
 There are several subsequences that achieve this length. One is 1,17,10,13,10,16,8.
 2)

 { 44 }
 Returns: 1
 3)

 { 1, 2, 3, 4, 5, 6, 7, 8, 9 }
 Returns: 2
 4)

 { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 }
 Returns: 8
 5)

 { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
 600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
 67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
 477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
 249, 22, 176, 279, 23, 22, 617, 462, 459, 244 }
 Returns: 36

 */
public class ZigZag {
    public static void main(String[] args) {
        int[] a1 = { 1, 7, 4, 9, 2, 5 };
        int[] a2 = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
        int[] a3 = { 44 };
        int[] a4 = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int[] a5 = { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32 };
        int[] a6 = { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
                600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
                67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
                477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
                249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
        int[] a7 = {10, 10};
        int[] a8 = {10, 20};
        int[] a9 = {10, 10, 20};

        ZigZag zig = new ZigZag();
        System.out.println(zig.longestZigZag(a1));
        System.out.println(zig.longestZigZag(a2));
        System.out.println(zig.longestZigZag(a3));
        System.out.println(zig.longestZigZag(a4));
        System.out.println(zig.longestZigZag(a5));
        System.out.println(zig.longestZigZag(a6));
        System.out.println(zig.longestZigZag(a7));
        System.out.println(zig.longestZigZag(a8));
        System.out.println(zig.longestZigZag(a9));
    }

    public int longestZigZag(int[] sequence) {
        if(sequence.length < 2) {
            return sequence.length;
        }
        // If first two numbers are same, we need to skip a number which means the currLength is not 2 but 1.
        int currLength = (sequence[1] - sequence[0] == 0) ? 1 : 2;
        // since we are using boolean, it's necessary to evaluate first two numbers
        // alternative would be to store the sub-sequence to a new array/list
        boolean previouslyPositive = sequence[1] - sequence[0] > 0;
        for(int i = 2; i < sequence.length; i++) {
            int diff  = sequence[i] - sequence[i - 1];
            if(diff != 0) {     // if two adjacent numbers are same, then they cant be part of zig zag
                boolean currentlyPositive = diff > 0;
                if (previouslyPositive ^ currentlyPositive) {
                    currLength++;
                    previouslyPositive = currentlyPositive;
                }
            }
        }
        return currLength;
    }
}
