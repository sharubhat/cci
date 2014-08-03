package c01.arrays.and.strings.p1_5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sharath on 8/2/14.
 */
public class StringCompressionTest {
    StringCompression sc;
    @Before
    public void setUp() {
        sc = new StringCompression();
    }

    @Test
    public void compressedStringIsLonger() {
        assertEquals("Compressed string is longer returns original", "anck", sc.compress("anck"));
    }

    @Test
    public void sameLenth() {
        assertEquals("Compressed string is of same length as original", "aabbcc", sc.compress("aabbcc"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullInput() {
        sc.compress(null);
    }

    @Test
    public void success() {
        assertEquals("Successfully compressed string", "a2b1c5a3", sc.compress("aabcccccaaa"));
    }

    @Test
    public void successLongString() {
        assertEquals("Successfully compressed string", "a12b4", sc.compress("aaaaaaaaaaaabbbb"));
    }

    @After
    public void tearDown() {
        sc = null;
    }
}
