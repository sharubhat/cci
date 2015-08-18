package topcoder_dp.intermediate;

/**
 * Created by sharath on 2/13/15.
 *
 * A table composed of N x M cells, each having a certain quantity of apples, is given.
 * You start from the upper-left corner. At each step you can go down or right one cell.
 * Find the maximum number of apples you can collect.
 */
public class MaxApples {
    public static void main(String[] args) {
        int table[][] = {{2, 4, 2},
                         {4, 5, 2},
                         {1, 1, 4}};

        System.out.println(new MaxApples().maxApples(table));
    }

    public int maxApples(int[][] table) {
        int N = table.length;
        int M = table[0].length;
        int[][] sum = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sum[i][j] = Math.max(i==0? 0:sum[i-1][j], j==0?0:sum[i][j-1]) + table[i][j];
            }
        }
        return sum[N-1][M-1];
    }
}
