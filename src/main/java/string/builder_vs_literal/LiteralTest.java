package string.builder_vs_literal;

/**
 * Created by sharath on 1/14/16.
 */
public class LiteralTest {
    public static void main(String[] args) {

        String temp = "Hi" + 200 + 'B';

        String s = "This is " +
                "single line " +
                "split to " +
                "multiple lines";

        StringBuilder sb = new StringBuilder();
        sb.append("This is ").append("single line ").append("split to ").append("multiple lines");
        String t = sb.toString();

        String k = "...";
        for(int i = 0; i < 10; i++) {
            k += "_" + i;
        }
    }
}
