// src/test/java/UserInterfaceTest.java
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        // Capture what showExchangeRates prints to standard out.
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(captured));
        try {
            ui.showExchangeRates();
        } finally {
            System.setOut(original);
        }

        String printed = captured.toString();
        assertTrue(printed.contains("Exchange Rates (base = 1 unit)"));
        assertTrue(printed.contains("\tUSD\tEUR\tGBP\tAUD"));
        assertTrue(printed.contains("USD\t1.00\t0.85\t0.75\t1.30"));
        assertTrue(printed.contains("EUR\t1.18\t1.00\t0.88\t1.53"));
        assertTrue(printed.contains("GBP\t1.33\t1.13\t1.00\t1.73"));
        assertTrue(printed.contains("AUD\t0.77\t0.65\t0.58\t1.00"));
    }

    /**
     * Run handleConversion against scripted keyboard input and return
     * everything it printed.
     *
     * <p>The UserInterface is constructed inside this method, after System.in
     * has been replaced. The constructor wraps whatever System.in is at that
     * moment in its Scanner, so the instance built in setUp() would read the
     * real keyboard and the test would hang.
     */
    private String runConversion(String keystrokes) {
        InputStream realIn = System.in;
        PrintStream realOut = System.out;
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(keystrokes.getBytes()));
            System.setOut(new PrintStream(captured));
            new UserInterface().handleConversion();
        } finally {
            System.setIn(realIn);
            System.setOut(realOut);
        }
        return captured.toString();
    }

    /**
     * The specified output is assessed character for character, so the whole
     * exchange is asserted rather than probed for substrings. The prompts use
     * print rather than println, which is why they run together here: input
     * read from a stream is not echoed the way typing at a terminal is.
     */
    @Test
    public void testHandleConversion() {
        String expected = "Enter amount: "
                        + "From currency (USD/EUR/GBP/AUD): "
                        + "To currency (USD/EUR/GBP/AUD): "
                        + "Result: 100.00 USD = 85.00 EUR" + System.lineSeparator();

        assertEquals(expected, runConversion("100\nUSD\nEUR\n"));
    }

    /**
     * An invalid amount must return to the menu immediately. Prompting for the
     * currencies first and reporting the error afterwards would print the right
     * message in the wrong place.
     */
    @Test
    public void testHandleConversionRejectsAmountBeforeAskingForCurrencies() {
        String printed = runConversion("abc\n");

        assertEquals("Enter amount: Invalid amount. Enter a positive number."
                     + System.lineSeparator(), printed);
        assertFalse(printed.contains("From currency"),
                    "an invalid amount must not reach the currency prompts");
    }

    /**
     * The mirror image of the rule above: both codes are read before either is
     * checked, so a bad "from" code still prompts for "to" before the single
     * error line appears.
     */
    @Test
    public void testHandleConversionReadsBothCurrenciesBeforeReportingOneInvalid() {
        String expected = "Enter amount: "
                        + "From currency (USD/EUR/GBP/AUD): "
                        + "To currency (USD/EUR/GBP/AUD): "
                        + "Invalid currency. Use USD, EUR, GBP or AUD."
                        + System.lineSeparator();

        assertEquals(expected, runConversion("100\nXXX\nEUR\n"));
        assertEquals(expected, runConversion("100\nUSD\nZZZ\n"));
    }

    /**
     * Codes are case-insensitive and surrounding whitespace is ignored, and the
     * result line shows the normalized form rather than what was typed.
     */
    @Test
    public void testHandleConversionNormalizesCurrencyCodes() {
        String tail = "Result: 100.00 USD = 85.00 EUR" + System.lineSeparator();

        assertTrue(runConversion("100\n usd \nEuR\n").endsWith(tail));
        assertTrue(runConversion("100\nUsd\n\teur\n").endsWith(tail));
    }

    /**
     * An amount is valid only if it parses as a number greater than zero, so
     * zero, negatives and blanks are all rejected with the same message.
     */
    @Test
    public void testHandleConversionRejectsNonPositiveAmounts() {
        for (String amount : new String[] {"0", "-5", "", "   ", "abc"}) {
            assertEquals("Enter amount: Invalid amount. Enter a positive number."
                         + System.lineSeparator(),
                         runConversion(amount + "\n"),
                         "amount [" + amount + "] should be rejected");
        }
    }

    /** A currency converted to itself is always 1.00, so the amount is unchanged. */
    @Test
    public void testHandleConversionConvertsACurrencyToItself() {
        assertTrue(runConversion("50\nAUD\nAUD\n")
                   .endsWith("Result: 50.00 AUD = 50.00 AUD" + System.lineSeparator()));
    }

    /** Decimal amounts are accepted and both sides are shown to two places. */
    @Test
    public void testHandleConversionAcceptsDecimalAmounts() {
        assertTrue(runConversion("12.5\nUSD\nGBP\n")
                   .endsWith("Result: 12.50 USD = 9.38 GBP" + System.lineSeparator()));
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
