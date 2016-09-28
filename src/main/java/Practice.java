import java.util.HashSet;
import java.util.Set;

/**
 * Created by bhatshar on 1/1/16.
 */
public class Practice {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(123);
        set.add(1234);
        set.add(1235);
        set.add(1236);

        System.out.println(set);
        String s = set.toString();
        System.out.println(s.substring(1, s.length() - 1));
    }
}
