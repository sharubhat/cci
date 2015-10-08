package hackerrank.arrays_strings_and_everything.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * In binary representation, hamming weight is the number of 1's.
 * One way is to create a look up table for all one byte integers and then check each byte at a time for the given
 * 4 byte integer. This is 4 look ups per given number.
 *
 * Other optimization can be storing the hamming weight of each number when it's calculated the first time so that if
 * input stream has same number, we can look it up from the table. This would take less time than earlier approach.
 *
 *
 * Created by sharath on 9/6/15.
 */
public class HammingWeight {
    static short ones(long x) {
        short result = 0;
        while(x != 0) {
            result += (x & 1);
            x >>= 1;
        }
        return result;
    }

    static int getLastByte(int n) {
        return n & ((1 << 8) - 1);
    }

    static int printCountOfBitsSet(int[] intArr) {
        Map<Integer, Short> store = new HashMap<>();
        for(int i = 0; i < 1 << 8; i++) {
            store.put(i, ones(i));
        }
        System.out.println(store);

        int result = 0;
        for(int i = 0; i < intArr.length; i++) {
            int curr = intArr[i];
            for(int j = 0; j < 4 && curr != 0; j++) {
                int lastByte = getLastByte(curr);
                result += store.get(lastByte);
                curr = curr >> 8;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] intArr = {2, 232, 29, 1, 100, 0};
        System.out.println(printCountOfBitsSet(intArr));
    }
}
