package hackerrank.graphs_and_other_ds.epi;

/**
 * Let F be a boolean nXn 2D array representing known relationships of n people - F[a][b] is true iff a knows b.
 * Design an algorithm to find a celebrity. Celebrity is the one whom everyone knows but he doesn't know anyone.
 *
 * Created by sharath on 11/2/15.
 */
public class IdentifyCelebrity {
    /**
     * Since one candidate is eliminated at a time in O(1) time, algorithm runs in O(n) time.
     *
     * @param F
     */
    public static void findCelebrity(boolean[][] F) {
        int i = 0, j  = 1;
        while(j < F.length) {
            if(F[i][j]) {
                i = j;
            }
            j++;
        }
        System.out.println("Celebrity found at index " + i);
    }

    public static void main(String[] args) {
        boolean[][] F = {{false, false, false, false},
                {true, false, false, false},
                {false, false, false, false},
                {true, false, true, false}};

        findCelebrity(F);
    }
}
