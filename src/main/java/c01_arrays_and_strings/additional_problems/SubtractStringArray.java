package c01_arrays_and_strings.additional_problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sharath on 8/28/14.
 */
public class SubtractStringArray {
    public void subtract(String[] s1, String[] s2) {
        Set<String> set1 = new HashSet<>(Arrays.asList(s1));
        Set<String> set2 = new HashSet<>(Arrays.asList(s2));
        set1.removeAll(set2);
        System.out.println(set1);
    }

    public static void main(String[] args) {
        String e1[] = { "Ac", "Bc", "Cc", "Dc", "Ec" };
        String e2[] = new String[] { "Bc", "Dc", "Fc", "Gc", "1c", "2c", "3c", "4c" };
        new SubtractStringArray().subtract(e1, e2);
    }
}
