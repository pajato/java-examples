import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Paul Michael Reilly
 */
public class MainTest {

    // Private class variables.

    // Public test methods.

    /** Ensure that the default constructor is exercised for maximum code coverage. */
    @Test public void testMain() {
        new Main();
    }

    @Test public void testMainMethod() {
        Main.main(null);
    }

    @Test public void test1() {
        final String input = "Practice makes perfect. you'll only get Perfect by practice."
            + " just practice!";
        final Map<String, String> expected = new HashMap<>();
        expected.put("practice", "3");
        expected.put("perfect", "2");
        expected.put("makes", "1");
        expected.put("get", "1");
        expected.put("by", "1");
        expected.put("just", "1");
        expected.put("youll", "1");
        expected.put("only", "1");
        runTest(input, expected);
    }

    @Test public void testNullInput() {
        assertNull("Null input returned a non-null result!", Main.getWordCounts(null));
    }

    @Test public void testEmtpyInput() {
        String[][] actual = Main.getWordCounts("");
        assertTrue("Empty input returned a non-empty result!", actual.length == 0);
    }
    // Private instance methods.

    private void runTest(final String input, final Map<String, String> expected) {
        System.out.println("Test" + 1);
        String[][] actual = Main.getWordCounts(input);
        assertEquals("The size of the computed result is wrong!", expected.size(), actual.length);
        for (int i = 1; i < actual.length; i++) {
            String actualWord = actual[i][0];
            String actualValue = actual[i][1];
            String expectedWord = expected.containsKey(actualWord) ? actualWord : "";
            String expectedValue = expected.get(actualWord);
            assertEquals("The word is wrong!", expectedWord, actualWord);
            assertEquals("The value is wrong!", expectedValue, actualValue);
        }
    }
}
