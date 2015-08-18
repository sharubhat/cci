package hackerrank.sorting_test;

import java.util.*;

/**
 * Created by sharath on 8/8/15.
 */
public class MinDifference {

    static class Pair {
        int a;
        int b;
        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return new String(a + " " + b + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();

        int[] input = new int[size];
        for(int i = 0; i < size; i++) {
            input[i] = scan.nextInt();
        }

        difference(input);
    }

    private static void difference(int[] in) {
        Arrays.sort(in);
        List<Pair> store = new LinkedList<>();
        int minDifference = Integer.MAX_VALUE;
        for(int i = 1; i < in.length; i++) {
            if(minDifference > Math.abs(in[i] - in[i-1])) {
                minDifference = Math.abs(in[i] - in[i-1]);
                store.clear();
                store.add(new Pair(in[i-1], in[i]));
            } else if(minDifference == Math.abs(in[i] - in[i-1])) {
                store.add(new Pair(in[i-1], in[i]));
            }
        }

        Iterator it = store.iterator();

        while(it.hasNext()) {
            System.out.print(it.next());
        }
    }
}
