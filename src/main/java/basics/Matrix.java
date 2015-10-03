package basics;

/**
 * Created by sharath on 10/1/15.
 */
public class Matrix {
    public static void main(String[] args) {
        // 2D arrays always is of the form array[rows][cols] or array[height][width]
        int[][] matrix = new int[5][7];
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // printing element at ith row and jth column
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
