package practicalunittesting.exercise;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;

/**
 * Created by sharath on 4/4/15.
 */
@RunWith(JUnitParamsRunner.class)
public class HashMapTest {
    private HashMap<String, String> map;

    @Before
    public void setUp() {
        map = new HashMap();
    }

    private Object[] getValidKeyValuePair() {
        return $($("a", "a-1"), $("b", "b-1"));
    }

    @Test
    @Parameters(method = "getValidKeyValuePair")
    public void objectPutInHashMapShouldBeRetrievedWithGet(String key, String value) {
        map.put(key, value);
        assertEquals(value, map.get(key));
    }
}
