package c09_recursion_and_dp.recursion;

/**
 * Created by sharath on 9/9/14.
 */
public class RecursiveStringLength {
    public int strLength(String str) {
        if(str == null || str.isEmpty())
            return 0;
        else
            return 1 + strLength(str.substring(1));
    }
}
