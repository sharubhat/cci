package hackerrank.recursion.cci;

/**
 * Created by sharath on 8/18/15.
 */
public class SubStrings {
    public static void printCombinations(String initial, String combined) {
        if(!combined.isEmpty())
            System.out.println(combined);
        for (int i = 0; i < initial.length(); i++) {
            printCombinations(initial.substring(i + 1),
                    combined + initial.charAt(i));

        }
    }


    public static void main(String[] args) {
        printCombinations("12345", "");
    }
}
