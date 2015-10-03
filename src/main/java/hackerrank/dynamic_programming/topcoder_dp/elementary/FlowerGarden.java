package hackerrank.dynamic_programming.topcoder_dp.elementary;

import java.util.*;

/**
 * Created by sharath on 2/12/15.
 * Topcoder problem
 *
 * Problem Statement

 You are planting a flower garden with bulbs to give you joyous flowers throughout the year.
 However, you wish to plant the flowers such that they do not block other flowers while they are visible.

 You will be given a int[] height, a int[] bloom, and a int[] wilt. Each type of flower is represented by
 the element at the same index of height, bloom, and wilt. height represents how high each type of flower grows,
 bloom represents the morning that each type of flower springs from the ground, and wilt represents the evening that
 each type of flower shrivels up and dies. Each element in bloom and wilt will be a number between 1 and 365 inclusive,
 and wilt[i] will always be greater than bloom[i]. You must plant all of the flowers of the same type
 in a single row for appearance, and you also want to have the tallest flowers as far forward as possible.
 However, if a flower type is taller than another type, and both types can be out of the ground at the same time,
 the shorter flower must be planted in front of the taller flower to prevent blocking. A flower blooms in the morning,
 and wilts in the evening, so even if one flower is blooming on the same day another flower is wilting, one can block the other.

 You should return a int[] which contains the elements of height in the order you should plant your flowers to achieve
 the above goals. The front of the garden is represented by the first element in your return value,
 and is where you view the garden from. The elements of height will all be unique, so there will always be
 a well-defined ordering.


 Definition

 Class:	FlowerGarden
 Method:	getOrdering
 Parameters:	int[], int[], int[]
 Returns:	int[]
 Method signature:	int[] getOrdering(int[] height, int[] bloom, int[] wilt)
 (be sure your method is public)


 Constraints
 -	height will have between 2 and 50 elements, inclusive.
 -	bloom will have the same number of elements as height
 -	wilt will have the same number of elements as height
 -	height will have no repeated elements.
 -	Each element of height will be between 1 and 1000, inclusive.
 -	Each element of bloom will be between 1 and 365, inclusive.
 -	Each element of wilt will be between 1 and 365, inclusive.
 -	For each element i of bloom and wilt, wilt[i] will be greater than bloom[i].

 Examples
 0)

 {5,4,3,2,1}
 {1,1,1,1,1}
 {365,365,365,365,365}
 Returns: { 1,  2,  3,  4,  5 }
 These flowers all bloom on January 1st and wilt on December 31st. Since they all may block each other,
 you must order them from shortest to tallest.
 1)

 {5,4,3,2,1}
 {1,5,10,15,20}
 {4,9,14,19,24}
 Returns: { 5,  4,  3,  2,  1 }
 The same set of flowers now bloom all at separate times. Since they will never block each other,
 you can order them from tallest to shortest to get the tallest ones as far forward as possible.
 2)

 {5,4,3,2,1}
 {1,5,10,15,20}
 {5,10,15,20,25}
 Returns: { 1,  2,  3,  4,  5 }
 Although each flower only blocks at most one other, they all must be ordered from shortest to tallest to prevent
 any blocking from occurring.
 3)

 {5,4,3,2,1}
 {1,5,10,15,20}
 {5,10,14,20,25}
 Returns: { 3,  4,  5,  1,  2 }
 The difference here is that the third type of flower wilts one day earlier than the blooming of the fourth flower.
 Therefore, we can put the flowers of height 3 first, then the flowers of height 4, then height 5,
 and finally the flowers of height 1 and 2. Note that we could have also ordered them with height 1 first,
 but this does not result in the maximum possible height being first in the garden.
 4)

 {1,2,3,4,5,6}
 {1,3,1,3,1,3}
 {2,4,2,4,2,4}
 Returns: { 2,  4,  6,  1,  3,  5 }
 5)

 {3,2,5,4}
 {1,2,11,10}
 {4,3,12,13}
 Returns: { 4,  5,  2,  3 }

 */
public class FlowerGarden {
    class Entry {
        int height, bloom, wilt;

        public Entry(int height, int bloom, int wilt) {
            this.height = height;
            this.bloom = bloom;
            this.wilt = wilt;
        }
    }

    class HeightComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry o1, Entry o2) {
            if(overlapping(o1, o2)) {
                if(o1.height == o2.height)
                    return 0;
                else if(o1.height < o2.height)
                    return -1;
                else
                    return 1;
            } else
                return 0;
        }

        private boolean overlapping(Entry o1, Entry o2) {
            return (o1.wilt >= o2.bloom && o1.wilt <= o2.wilt) ||
                    (o2.wilt >= o1.bloom && o2.wilt <= o1.bloom);
        }
    }

    class BloomComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry o1, Entry o2) {
            if(o1.bloom == o2.bloom)
                return 0;
            else if(o1.bloom < o2.bloom)
                return -1;
            else
                return 1;
        }
    }

    int[] getOrdering(int[] height, int[] bloom, int[] wilt) {
        List<Entry> entries = getEntries(height, bloom, wilt);
        Collections.sort(entries, new HeightComparator());
        Collections.sort(entries, new BloomComparator());
        return print(entries);
    }

    private int[] print(List<Entry> entries) {
        int[] ordering = new int[entries.size()];
        for(int i = 0; i < ordering.length; i++) {
            ordering[i] = entries.get(i).height;
        }

        System.out.println("*************************");
        for(int i = 0; i < ordering.length; i++) {
            System.out.printf("%4d ", entries.get(i).height);
        }
        System.out.println();
        for(int i = 0; i < ordering.length; i++) {
            System.out.printf("%4d ", entries.get(i).bloom);
        }
        System.out.println();
        for(int i = 0; i < ordering.length; i++) {
            System.out.printf("%4d ", entries.get(i).wilt);
        }
        System.out.println("\n*************************");
        System.out.println();
        return ordering;
    }

    private List<Entry> getEntries(int[] height, int[] bloom, int[] wilt) {
        List<Entry> entries = new ArrayList<>(height.length);
        for(int i = 0; i < height.length; i++) {
            entries.add(new Entry(height[i], bloom[i], wilt[i]));
        }
        return entries;
    }

    public static void main(String[] args) {
        int[] height = {5,4,3,2,1};
        int[] bloom = {1,5,10,15,20};
        int[] wilt = {5,10,14,20,25};
        FlowerGarden f = new FlowerGarden();
        int[] ordering = f.getOrdering(height, bloom, wilt);

        for(int order : ordering)
            System.out.print(order + " ");

        System.out.println();

        int[] h = {890, 330, 373, 323, 363, 636, 269, 768, 112, 734, 96, 245, 75, 607, 927, 655, 28, 254, 307, 127, 110, 14, 719, 787, 847, 652, 893, 878, 111, 856, 577, 326, 199, 723, 285, 31, 659, 996, 543, 128, 718, 643, 60};
        int[] b = {342, 35, 213, 225, 339, 21, 121, 233, 241, 180, 92, 123, 128, 284, 283, 346, 54, 295, 124, 256, 38, 48, 348, 327, 311, 321, 23, 78, 334, 221, 86, 303, 108, 311, 356, 357, 219, 77, 279, 292, 24, 228, 38};
        int[] w = {351, 131, 266, 231, 358, 194, 260, 329, 255, 286, 203, 277, 138, 333, 364, 354, 117, 347, 260, 325, 55, 352, 349, 337, 332, 342, 151, 92, 361, 289, 93, 308, 324, 341, 365, 362, 242, 103, 361, 331, 314, 326, 256};

        int[] result = {31, 14, 111, 285, 28, 60, 127, 128, 112, 110, 75, 96, 199, 254, 363, 326, 543, 655, 719, 607, 245, 269, 307, 330, 577, 636, 323, 373, 643, 659, 718, 878, 893, 996, 734, 652, 890, 723, 768, 856, 787, 847, 927};
        int[] o = f.getOrdering(h, b, w);

        if(result.length == o.length) {
            for (int i = 0; i < h.length; i++) {
                System.out.printf("%4d ", h[i]);
            }
            System.out.println();
            for (int i = 0; i < b.length; i++) {
                System.out.printf("%4d ", b[i]);
            }
            System.out.println();
            for (int i = 0; i < w.length; i++) {
                System.out.printf("%4d ", w[i]);
            }
            System.out.println();

            for (int i = 0; i < result.length; i++) {
                System.out.printf("%4d ", result[i]);
            }
            System.out.println();
            for (int i = 0; i < o.length; i++) {
                System.out.printf("%4d ", o[i]);
            }
        }
    }
}
