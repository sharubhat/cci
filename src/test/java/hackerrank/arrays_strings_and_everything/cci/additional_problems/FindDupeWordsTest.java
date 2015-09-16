package hackerrank.arrays_strings_and_everything.cci.additional_problems;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by sharath on 8/11/14.
 */
public class FindDupeWordsTest {
    FindDupeWords findDupeWords;
    @Before
    public void setUp() {
        findDupeWords = new FindDupeWords();
    }

    @Test
    public void testEmptyString() {
        assertEquals(new ArrayList<String>(), findDupeWords.duplicates(""));
    }

    @Test
    public void testNoDupes() {
        assertEquals(new ArrayList<String>(), findDupeWords.duplicates("This has no duplicates"));
    }

    @Test
    public void testWithDupes() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("has");
        list.add("a");
        list.add("view.");
        assertEquals(list, findDupeWords.duplicates("This has a good view. It also has a different view."));
    }

    @After
    public void tearDown() {
        findDupeWords = null;
    }
}
