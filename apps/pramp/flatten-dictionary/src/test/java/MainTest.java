import org.junit.Test;

import com.google.gson.Gson;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Test that the ... test cases should include:
 *
 * 1) an empty dictionary.
 *
 * @author Paul Michael Reilly
 */
public class MainTest {

    @Test public void test1() {
        // 1) ...
        String input = "{\"Key1\":\"1\",\"Key2\":{\"a\":\"2\",\"b\":\"3\",\"c\":{\"d\":\"3\",\"e\":\"1\"}}}";
        String output = "{\"Key1\":\"1\",\"Key2.a\":\"2\",\"Key2.b\":\"3\",\"Key2.c.d\":\"3\",\"Key2.c.e\":\"1\"}";
        runTest(1, input, output);
    }

    @Test public void test2() {
        // 1) ...
        String input = "{\"Key\":{\"a\":\"2\",\"b\":\"3\"}}";
        String output = "{\"Key.a\":\"2\",\"Key.b\":\"3\"}";
        runTest(2, input, output);
    }

    @Test public void test3() {
        // 1) ...
        String input = "{\"Key1\":\"1\",\"Key2\":{\"a\":\"2\",\"b\":\"3\",\"c\":{\"d\":\"3\",\"e\":{\"f\":\"4\"}}}}";
        String output = "{\"Key1\":\"1\",\"Key2.a\":\"2\",\"Key2.b\":\"3\",\"Key2.c.d\":\"3\",\"Key2.c.e.f\":\"4\"}";
        runTest(3, input, output);
    }

    @Test public void test4() {
        // 1) ...
        String input = "{\"\":{\"a\":\"1\"},\"b\":\"3\"}";
        String output = "{\"a\":\"1\",\"b\":\"3\"}";
        runTest(4, input, output);
    }

    @Test public void test5() {
        // 1) ...
        String input = "{\"a\":{\"b\":{\"c\":{\"d\":{\"e\":{\"f\":{\"\":\"pramp\"}}}}}}}";
        String output = "{\"a.b.c.d.e.f\":\"pramp\"}";
        runTest(5, input, output);
    }

    @Test public void test6() {
        // 1) ...
        String input = "{\"a\":\"1\"}";
        String output = "{\"a\":\"1\"}";
        runTest(6, input, output);
    }

    private HashMap<String, Object> getDictionary(final String json) {
        return new Gson().fromJson(json, HashMap.class);
    }

    private HashMap<String, String> getResult(final String json) {
        return new Gson().fromJson(json, HashMap.class);
    }

    private void runTest(final int testNum, final String input, final String output) {
        System.out.println("Test" + testNum);
        HashMap<String, String> actual = Main.flattenDictionary(getDictionary(input));
        HashMap<String, String> expected = getResult(output);
        assertTrue("Map is null!", actual != null);
        assertEquals("The actual map size is wrong!", expected.size(), actual.size());
        final String format = "The actual value is wrong for key: {%s}!";
        for (String key : expected.keySet()) {
            String expStr = expected.get(key);
            String actStr = actual.get(key);
            assertEquals(String.format(Locale.US, format, key), expStr, actStr);
        }
    }
}
