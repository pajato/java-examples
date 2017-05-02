import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;

public class MainTest {

    @Test public void test0() {
        runTest("1 3", "Prime");
    }

    @Test public void test1() {
        runTest("1 7", "Prime");
    }

    @Test public void test2() {
        runTest("1 9", "Not prime");
    }

    @Test public void test3() {
        runTest("1 11", "Prime");
    }

    @Test public void test4() {
        runTest("1 89", "Prime");
    }

    @Test public void test5() {
        runTest("1 100", "Not prime");
    }

    @Test public void test6() {
        runTest("1 101", "Prime");
    }

    @Test public void test7() {
        runTest("1 1000000007", "Prime");
    }

    @Test public void test8() {
        runTest("1 100000003", "Not prime");
    }

    @Test public void test9() {
        runTest("1 1000003", "Prime");
    }

    @Test public void test10() {
        runTest("1 2", "Prime");
    }

    @Test public void test11() {
        runTest("1 1", "Not prime");
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
