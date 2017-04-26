import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;

public class MainTest {
    @Test public void test0() {
        runTest("20 3 9 9 11 11 11 11 89 89 100 100 101 102 103 108 200 250 250 250 250",
                "3 9 11 89 100 101 102 103 108 200 250");
    }

    private void runTest(String input, String expected) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stdout = System.out;
        System.setOut(new PrintStream(out));
        Main.main(null);
        String actual = out.toString().trim();
        assertEquals(expected, actual);
        System.setOut(stdout);
        System.out.println(actual);
    }
}
