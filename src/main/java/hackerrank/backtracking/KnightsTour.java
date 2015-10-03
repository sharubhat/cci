package hackerrank.backtracking;

/**
 * A knight’s tour is a sequence of moves of a knight on a chessboard such that the knight visits every square only once.
 * If the knight ends on a square that is one knight’s move from the beginning square (so that it could tour
 * the board again immediately, following the same path), the tour is closed, otherwise it is open.
 *
 * Created by sharath on 9/30/15.
 */
public class KnightsTour {
    int[][] solution;
    int path = 0;

    public KnightsTour(int n) {
        this.solution = new int[n][n];
    }

    public void solve() {
        if(findPath(0, 0, 0, this.solution.length))
            print();
        else
            System.out.println("No closed path found");
    }

    private void print() {
        for(int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean findPath(int row, int col, int index, int length) {
        if(solution[row][col] != 0)
            return false;
        solution[row][col] = path++;

        if(index == length * length - 1)
            return true;

        // else there are 8 possible moves
        if(canMove(row+2, col+1, length) && findPath(row+2, col+1, index+1, length))
            return true;
        if(canMove(row+1, col+2, length) && findPath(row+1, col+2, index+1, length))
            return true;
        if(canMove(row-1, col+2, length) && findPath(row-1, col+2, index+1, length))
            return true;
        if(canMove(row-2, col+1, length) && findPath(row-2, col+1, index+1, length))
            return true;
        if(canMove(row-2, col-1, length) && findPath(row-2, col-1, index+1, length))
            return true;
        if(canMove(row-1, col-2, length) && findPath(row-1, col-2, index+1, length))
            return true;
        if(canMove(row+1, col-2, length) && findPath(row+1, col-2, index+1, length))
            return true;
        if(canMove(row+2, col-1, length) && findPath(row+2, col-1, index+1, length))
            return true;
        solution[row][col] = 0;
        path--;
        return false;
    }

    private boolean canMove(int row, int col, int length) {
        if(row >= 0 && col >= 0 && row < length && col < length)
            return true;
        return false;
    }

    public static void main(String[] args) {
        KnightsTour k = new KnightsTour(8);
        k.solve();
    }
}
