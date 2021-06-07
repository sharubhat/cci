package c04_trees_and_graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class IdenticalBSTsTest {

    @Test
    public void isIdentical() {
        assertTrue(IdenticalBSTs.isIdentical(new int[]{2, 4, 1, 3}, new int[]{2, 4, 3, 1}));
        assertTrue(IdenticalBSTs.isIdentical(new int[]{8, 3, 6, 1, 4, 7, 10, 14, 13}, new int[]{8, 10, 14, 3, 6, 4, 1, 7, 13}));
        assertFalse(IdenticalBSTs.isIdentical(new int[]{2, 4, 1, 3}, new int[]{2, 3, 4, 1}));
    }
}