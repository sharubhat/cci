package c01_arrays_and_strings.p1_6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by sharath on 8/2/14.
 */
public class RotateMatrixTest {
    RotateMatrix rotateMatrix;
    @Before
    public void setUp() {
        rotateMatrix = new RotateMatrix();
    }

    @Test
    public void rotate() {
        int[][] input = {{0, 8, 8, 9, 4, 6, 5, 2, 2, 0},
                {7, 7, 4, 1, 9, 6, 2, 3, 3, 0},
                {6, 5, 9, 5, 1, 5, 8, 9, 0, 4},
                {6, 3, 8, 6, 3, 6, 0, 4, 1, 2},
                {9, 7, 2, 1, 3, 7, 2, 6, 8, 0},
                {0, 8, 5, 9, 8, 0, 8, 6, 2, 5},
                {4, 7, 1, 6, 8, 0, 8, 9, 5, 2},
                {3, 9, 4, 5, 7, 8, 7, 5, 4, 6},
                {3, 4, 4, 6, 6, 1, 3, 6, 1, 3},
                {6, 6, 2, 4, 1, 5, 3, 3, 0, 5}};
        int[][] output = {{6, 3, 3, 4, 0, 9, 6, 6, 7, 0},
                {6, 4, 9, 7, 8, 7, 3, 5, 7, 8},
                {2, 4, 4, 1, 5, 2, 8, 9, 4, 8},
                {4, 6, 5, 6, 9, 1, 6, 5, 1, 9},
                {1, 6, 7, 8, 8, 3, 3, 1, 9, 4},
                {5, 1, 8, 0, 0, 7, 6, 5, 6, 6},
                {3, 3, 7, 8, 8, 2, 0, 8, 2, 5},
                {3, 6, 5, 9, 6, 6, 4, 9, 3, 2},
                {0, 1, 4, 5, 2, 8, 1, 0, 3, 2},
                {5, 3, 6, 2, 5, 0, 2, 4, 0, 0}};
        assertArrayEquals(output, rotateMatrix.rotate90degrees(input));
    }

    @After
    public void tearDown() {
        rotateMatrix = null;
    }
}
