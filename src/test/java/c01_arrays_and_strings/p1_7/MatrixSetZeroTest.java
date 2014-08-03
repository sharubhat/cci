package c01_arrays_and_strings.p1_7;

import org.junit.*;

/**
 * Created by sharath on 8/2/14.
 */
public class MatrixSetZeroTest {
    MatrixSetZero setZero;
    @Before
    public void setUp() {
        setZero = new MatrixSetZero();
    }

    @Test
    public void checkAllZeros() {
        int[][] input = {{0,0,0,0,},{0,0,0,0,},{0,0,0,0,},{0,0,0,0,},{0,0,0,0,}};
        int[][] output = {{0,0,0,0,},{0,0,0,0,},{0,0,0,0,},{0,0,0,0,},{0,0,0,0,}};
        Assert.assertArrayEquals(output, setZero.setZero(input));
    }

    @Test
    public void checkMatrixWithFewZeros() {
        int[][] input = new int[][] {{1, 2, 3, 4}, {1, 2, 0, 4}, {1, 2, 3, 4}, {1, 2, 3, 0}};
        int[][] output = new int[][] {{1, 2, 0, 0},{0, 0, 0, 0},{1, 2, 0, 0},{0, 0, 0, 0}};
        Assert.assertArrayEquals(output, setZero.setZero(input));
    }

    @Test
    public void checkMatrixWithNoZeros() {
        int[][] input = new int[][] {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 3}};
        Assert.assertArrayEquals(input, setZero.setZero(input));
    }

    @Test
    public void singleRowMatrix() {
        int[][] input = new int[][] {{1, 2, 3, 4}};
        Assert.assertArrayEquals(input, setZero.setZero(input));
        input = new int[][]{{1,2,3,0}};
        int[][] output = new int[][]{{0,0,0,0}};
        Assert.assertArrayEquals(output, setZero.setZero(input));
    }

    @After
    public void tearDown(){
        setZero = null;
    }
}
