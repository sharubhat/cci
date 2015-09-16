package hackerrank.arrays_strings_and_everything.cci.p1_7;

/**
 * Created by sharath on 8/2/14.
 *
 * Problem description:
 * If any element in a matrix is 0, then set all elements in that row and column to zero
 *
 *
 */
public class MatrixSetZero {
    public int[][] setZero(int[][] a) {
        boolean[] rows = new boolean[a.length];
        boolean[] columns = new boolean[a[0].length];

        for(int i = 0; i< a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                if(a[i][j] == 0) {
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for(int i = 0; i< rows.length; i++) {
            if(rows[i]) {
                for(int j = 0; j < a[i].length; j++) {
                    a[i][j] = 0;
                }
            }
        }

        for(int i = 0; i< columns.length; i++) {
            if(columns[i]) {
                for(int j = 0; j < a.length; j++) {
                    a[j][i] = 0;
                }
            }
        }
        return a;
    }
}
