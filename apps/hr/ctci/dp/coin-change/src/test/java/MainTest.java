import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;

public class MainTest {
    @Test public void test0() {
        runTest("4 3 1 2 3", "4");
    }

    @Test public void test1() {
        runTest("10 4 2 5 3 6", "5");
    }

    @Test public void test2() {
        runTest("4 2 2 6", "1");
    }

    @Test public void test3() {
        runTest("0 2 2 6", "0");
    }

    @Test public void test4() {
        runTest("125 7 125 6 1 9 4 15 7" , "23983");
    }

    @Test public void test5() {
        runTest("116 4 25 10 5 1" , "343");
    }

    private void runTest(String input, String expected) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stdout = System.out;
        System.setOut(new PrintStream(out));
        Main.main(null);
        String output = out.toString();
        assertEquals(expected, out.toString());
        System.setOut(stdout);
        System.out.println(output);
    }
}
