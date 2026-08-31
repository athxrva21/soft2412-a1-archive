// src/test/java/DataValidatorTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for DataValidator
 */
public class DataValidatorTest {

    private DataValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new DataValidator();
    }

    @Test
    @Disabled("isValidCurrency is a cycle 3 method")
    public void testValidCurrencies() {
        // TODO: Test that USD, EUR, GBP, AUD are valid
        assertTrue(validator.isValidCurrency("USD"));
        assertTrue(validator.isValidCurrency("EUR"));
        assertTrue(validator.isValidCurrency("GBP"));
        assertTrue(validator.isValidCurrency("AUD"));
    }

    @Test
    @Disabled("isValidCurrency is a cycle 3 method")
    public void testInvalidCurrencies() {
        // TODO: Test that invalid currencies are rejected
        // The positive case is asserted here too, so this test cannot pass
        // against a method that simply returns false.
        assertTrue(validator.isValidCurrency("USD"));
        assertFalse(validator.isValidCurrency("XYZ"));
        assertFalse(validator.isValidCurrency(""));
        assertFalse(validator.isValidCurrency(null));
        assertFalse(validator.isValidCurrency("INVALID"));
    }

    @Test
    @Disabled("isValidAmount is a cycle 3 method")
    public void testValidAmounts() {
        // TODO: Test that valid amount strings are accepted
        assertTrue(validator.isValidAmount("100"));
        assertTrue(validator.isValidAmount("0.01"));
        assertTrue(validator.isValidAmount("1000.50"));
    }

    @Test
    @Disabled("isValidAmount is a cycle 3 method")
    public void testInvalidAmounts() {
        // TODO: Test that invalid amounts are rejected
        // The positive case is asserted here too, so this test cannot pass
        // against a method that simply returns false.
        assertTrue(validator.isValidAmount("100"));
        assertFalse(validator.isValidAmount("-100"));
        assertFalse(validator.isValidAmount("abc"));
        assertFalse(validator.isValidAmount(""));
        assertFalse(validator.isValidAmount(null));
    }

    @Test
    public void testParseAmount() {
        // Whole numbers and decimals both parse.
        assertEquals(100.0, validator.parseAmount("100"), 0.01);
        assertEquals(50.75, validator.parseAmount("50.75"), 0.01);

        // A string that is not a number gives 0.0 instead of throwing.
        assertEquals(0.0, validator.parseAmount("invalid"));
    }

    @Test
    public void testParseAmountRejectsUnusableInput() {
        // Double.parseDouble(null) throws NullPointerException, not
        // NumberFormatException, so null has to be handled before the parse.
        assertEquals(0.0, validator.parseAmount(null));

        // Empty and whitespace-only strings are not numbers.
        assertEquals(0.0, validator.parseAmount(""));
        assertEquals(0.0, validator.parseAmount("   "));

        // These parse successfully but are not usable amounts; returning one
        // would carry it through the conversion and print it as the result.
        assertEquals(0.0, validator.parseAmount("NaN"));
        assertEquals(0.0, validator.parseAmount("Infinity"));
        assertEquals(0.0, validator.parseAmount("-Infinity"));
    }

    @Test
    public void testParseAmountConvertsWithoutJudging() {
        // Surrounding whitespace is trimmed, as a value typed at the menu
        // can carry it.
        assertEquals(100.0, validator.parseAmount("  100  "), 0.01);

        // parseAmount only converts; whether an amount is positive is decided
        // by isValidAmount, so a negative string still parses to its value.
        assertEquals(-5.0, validator.parseAmount("-5"), 0.01);

        // Zero is a number, and is returned as one.
        assertEquals(0.0, validator.parseAmount("0"), 0.01);
    }

    @Test
    @Disabled("normalizeCurrency is a cycle 3 method")
    public void testNormalizeCurrency() {
        // TODO: Test currency normalization
        assertEquals("USD", validator.normalizeCurrency("usd"));
        assertEquals("EUR", validator.normalizeCurrency(" eur "));
        assertEquals("GBP", validator.normalizeCurrency("Gbp"));
    }

    @Test
    @Disabled("isValidCurrency is a cycle 3 method")
    public void testCaseInsensitiveCurrency() {
        // TODO: Test that currency validation is case-insensitive
        assertTrue(validator.isValidCurrency("usd"));
        assertTrue(validator.isValidCurrency("EUR"));
        assertTrue(validator.isValidCurrency("Gbp"));
    }
}
