package c01_arrays_and_strings.additional_problems;

import java.util.*;

/**
 * Created by sharath on 8/28/14.
 */
public class SubtractStringArray {

    public void subtract(String[] s1, String[] s2) {
        // Arrays.asList returns a List. This is an interface type.
        // It can't be type casted to any concrete type such as ArrayList
        // So you need to create a new ArrayList from the list returned.
        List<String> list1 = new ArrayList<>(Arrays.asList(s1));
        List<String> list2 = new ArrayList<>(Arrays.asList(s2));
        list1.removeAll(list2);
        System.out.println(list1);

        // if you want to return String array since args are so
        // return list1.toArray(new String[list1.size()]);
    }

    public static void main(String[] args) {
        String e1[] = { "Ac", "Bc", "Cc", "Dc", "Ec", "Ac" };
        String e2[] = new String[] { "Bc", "Dc", "Fc", "Gc", "1c", "2c", "3c", "4c" };
        new SubtractStringArray().subtract(e1, e2);
    }
}
