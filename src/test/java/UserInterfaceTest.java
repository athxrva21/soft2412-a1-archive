// src/test/java/UserInterfaceTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Tests for UserInterface
 */
public class UserInterfaceTest {

    private UserInterface ui;

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
        PrintStream realOut = System.out;
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        try {
            System.setOut(new PrintStream(captured));
            ui.showMenu();
        } finally {
            System.setOut(realOut);
        }
        String out = captured.toString();
        assertTrue(out.contains("=== Currency Converter ==="));
        assertTrue(out.contains("1. Convert Currency"));
        assertTrue(out.contains("2. View Exchange Rates"));
        assertTrue(out.contains("3. Exit"));
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
        // TODO: Test that start method exists
        // Be careful - this might run indefinitely, so test carefully
        fail("Test not implemented yet");
    }
}
