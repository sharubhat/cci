package javacodegeeeks.c02_methods_common_to_all_objects;

import java.util.Arrays;

/**
 * Created by sharath on 7/31/15.
 */
public class ArraysToString {
    static class Fun {
        int id;
        String name;
        Fun(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("%s[id = %s, name = %s]", this.getClass().getSimpleName(), id, name);
        }
    }

    public static void main(String[] args) {
        Fun[] funs = {new Fun(1, "Chess"), new Fun(2, "Tennis")};
        Object[] objects = {funs ,new Fun(2, "Tennis")} ;

        System.out.println(Arrays.toString(objects));

        // deepToString converts array within array also to string.
        System.out.println(Arrays.deepToString(objects));
    }
}
