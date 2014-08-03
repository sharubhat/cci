package c01.arrays.and.strings.p1_6;

/**
 * Created by sharath on 8/2/14.
 *
 * Problem description:
 * Given an image represented by a N x N matrix, rotate it by 90 degree
 * Can you do it in place?
 *
 * Note, i increases going to right and downwards
 * offset increases going up and left but has to be subtracted from L
 * (F,0)(F,i).................(F,L)
 * ...........................(i,L)
 * ................................
 * ................................
 * (L-offset,F)....................
 * (L, F)........(L, L-offset)(L,L)
 *
 */
public class RotateMatrix {
    public int[][] rotate90degrees(int[][] a) {
        int size = a[0].length;

        for(int layer = 0; layer < size / 2; layer++) {
            int F = layer;
            int L = size -1 - layer;
            for(int i = F; i < L; i++) {
                int offset = i - F;
                // store left top
                int top = a[F][i];
                // left top = left bottom
                a[F][i] = a[L-offset][F];
                // left bottom = right bottom
                a[L-offset][F] = a[L][L-offset];
                // right bottom = right top
                a[L][L-offset] = a[i][L];
                // right top = stored top
                a[i][L] = top;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] a = randomMatrix(10, 10, 0, 9);
        for(int[] i : a) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
        int[][] result = new RotateMatrix().rotate90degrees(a);
        for(int[] i : result) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return matrix;
    }

    private static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    private static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

}
