package hackerrank.recursion.classroom;

/**
 * Given a M x N matrix, find the shortest path from left top entry to right bottom entry.
 * Only right and downwards movements are possible.
 *
 * time complexity is O(2^(m+n)).
 * Accurate number of steps needed is (l!)/(m-1)!(n-1)! where l = (m-1) + (n-1) is the length of the path.
 *
 * Note that the recursion tree is not full binary tree because some paths don't split once they reach either m or n.
 * So the size of the tree is not exactly 2^n. Whatever path is taken, it has same number of right and downward movements
 * which is m-1, n-1, just their ordering differs.
 *
 * Space complexity is O(l) = O(m+n) which is height of recursion tree(m-1+n-1)
 *
 * Created by sharath on 8/14/15.
 */
public class MaxPathInMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {1,4,7,1,2},
                {5,3,8,5,2},
                {0,2,8,3,6},
                {1,1,5,3,7}
        };

        System.out.println(maxPath(mat, mat.length - 1, mat[0].length - 1));
    }

    private static int maxPath(int[][] arr, int r, int c) {
        // if both r and c are 0, it's starting point
        if(r == 0 && c == 0) {
            return arr[r][c];
        }
        // if either r or c is 0, you can either only go upwards or only leftwards
        if(r == 0 || c == 0) {
            if (r != 0)
                return maxPath(arr, r - 1, c) + arr[r][c];
            if (c != 0)
                return maxPath(arr, r, c - 1) + arr[r][c];
        }

        // if both r and c are not 0
        return Math.max(maxPath(arr, r - 1, c), maxPath(arr, r, c - 1)) + arr[r][c];
    }
}
