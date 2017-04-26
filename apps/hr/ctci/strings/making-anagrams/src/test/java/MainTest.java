import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.*;

public class MainTest {
    @Test public void aTest() {
        String data = "5 4 1 2 3 4 5";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stdout = System.out;
        System.setOut(new PrintStream(out));
        Main.main(null);
        String output = out.toString();
        assertEquals("5 1 2 3 4", out.toString());
        System.setOut(stdout);
        System.out.println(output);
    }
}
