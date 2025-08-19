import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Tests for App.
 *
 * App reads from System.in, so a test that calls main() must supply the input
 * itself. The pattern below -- swap System.in and System.out, run, then put
 * them back -- is the one to reuse whenever you test UserInterface.
 */
public class AppTest {

    /**
     * DO NOT DELETE. This test is what covers App, which you are not otherwise
     * asked to write tests for. Without it you cannot reach 100% statement
     * coverage, because `new App()` is the only thing that reaches App's
     * default constructor.
     */
    @Test
    public void testAppRunsAndExits() {
        InputStream realIn = System.in;
        PrintStream realOut = System.out;
        try {
            // "3" is the Exit menu option: main should start up and come straight back.
            System.setIn(new ByteArrayInputStream("3\n".getBytes()));
            System.setOut(new PrintStream(new ByteArrayOutputStream()));

            App.main(new String[]{});
            new App();
        } finally {
            System.setIn(realIn);
            System.setOut(realOut);
        }
    }
}
