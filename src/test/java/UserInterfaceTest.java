// src/test/java/UserInterfaceTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for UserInterface
 */
public class UserInterfaceTest {

    private UserInterface ui;

    private static class StubUserInterface extends UserInterface {
        private int menuCalls;
        private int conversionCalls;
        private int exchangeRateCalls;

        @Override
        public void showMenu() {
            menuCalls++;
        }

        @Override
        public void handleConversion() {
            conversionCalls++;
        }

        @Override
        public void showExchangeRates() {
            exchangeRateCalls++;
        }
    }

    @BeforeEach
    public void setUp() {
        ui = new UserInterface();
    }

    @Test
    public void testUserInterfaceCreation() {
        // TODO: Test that UserInterface can be created
        assertNotNull(ui);
    }

    @Test
    public void testShowMenu() {
        // TODO: Test that showMenu method exists and runs
        // You might capture System.out to test menu display
        fail("Test not implemented yet");
    }

    @Test
    public void testShowExchangeRates() {
        // TODO: Test that showExchangeRates displays rates
        fail("Test not implemented yet");
    }

    @Test
    public void testHandleConversion() {
        // TODO: Test conversion handling
        // This is tricky - you might need to mock user input
        fail("Test not implemented yet");
    }

    @Test
    public void testStartMethod() {
        InputStream realIn = System.in;
        PrintStream realOut = System.out;
        try {
            System.setIn(new ByteArrayInputStream("1\n2\n9\n3\n".getBytes()));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            System.setOut(new PrintStream(output));

            StubUserInterface stubUi = new StubUserInterface();
            stubUi.start();

            assertEquals(4, stubUi.menuCalls);
            assertEquals(1, stubUi.conversionCalls);
            assertEquals(1, stubUi.exchangeRateCalls);
            assertTrue(output.toString().contains("Invalid choice. Enter 1, 2 or 3."));
            assertTrue(output.toString().contains("Goodbye."));
        } finally {
            System.setIn(realIn);
            System.setOut(realOut);
        }
    }
}
