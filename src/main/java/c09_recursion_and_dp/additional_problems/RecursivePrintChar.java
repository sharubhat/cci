package c09_recursion_and_dp.additional_problems;

/**
 * Created by sharath on 9/9/14.
 */
public class RecursivePrintChar {
    public void printChars(String str) {
        if(str == null || str.isEmpty())
            return;
        else {
            System.out.println(str.charAt(0));
            printChars(str.substring(1));
        }
    }
}
