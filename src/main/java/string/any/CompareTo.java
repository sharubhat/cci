package string.any;

/**
 * Created by sharath on 1/20/15.
 */
public class CompareTo {

        public static void main(String args[]) {
            String str1 = "A";
            String str2 = "B";
            String str3 = "C";

            int result = str1.compareTo(str2);
            System.out.println(result);

            result = str2.compareTo(str3);
            System.out.println(result);

            result = str3.compareTo(str1);
            System.out.println(result);
        }
}
