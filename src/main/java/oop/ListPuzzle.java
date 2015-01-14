package oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sharath on 9/24/14.
 */
public class ListPuzzle {
    public static void main(String args[]) {
        List<String> circus1 = new ArrayList<>();
        circus1.add("Monkey");
        circus1.add("Elephant");

        List<String> zoo1 = new ArrayList<>(circus1);
        zoo1.add("Lion");
        System.out.println(zoo1.getClass());
        System.out.println("zoo1 size: " + zoo1.size());

        String[] circus2 = { "Monkey", "Elephant" };

        List<String> zoo2 = Arrays.asList(circus2);
        System.out.println(zoo2);
        zoo2.set(1, "Tiger");
        System.out.println(zoo2);
        System.out.println(Arrays.toString(circus2));
        System.out.println("zoo2 size: " + zoo2.size());
    }

}
