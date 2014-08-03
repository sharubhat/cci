package c01_arrays_and_strings.p1_4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sharath on 8/2/14.
 */
public class ReplacesSpacesTest {
    ReplaceSpaces replaceSpaces;
    @Before
    public void setUp() throws Exception {
        replaceSpaces = new ReplaceSpaces();
    }

    @Test(expected = IllegalArgumentException.class)
    public void replaceNull() {
        replaceSpaces.replaceSpaces(null);
    }

    @Test
    public void replaceWithNoSpaces() {

    }

    @Test
    public void replacesWithSpacesInBetn() {
        assertEquals("String with spaces in between", new String("Hi%20There"), replaceSpaces.replaceSpaces("Hi There"));
    }

    @Test
    public void replacesWithLeadingSpaces() {
        assertEquals("String with leading spaces", "%20%20%20You%20there?",
                replaceSpaces.replaceSpaces("   You there?"));
    }

    @Test
    public void replacesWithTrailingSpaces() {
        assertEquals("String with trailing spaces", "You%20are%20%20welcome%20%20",
                replaceSpaces.replaceSpaces("You are  welcome  "));
    }

    @After
    public void tearDown() throws Exception {
        replaceSpaces = null;
    }
}
