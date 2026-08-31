
// src/test/java/CurrencyConverterTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for CurrencyConverter
 */
public class CurrencyConverterTest {

    private CurrencyConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new CurrencyConverter();
    }

    @Test
    public void testConvertUSDToEUR() {
        // TODO: Test converting 100 USD to EUR
        // Should return approximately 85.0 if rate is 0.85
        fail("Test not implemented yet");
    }

    @Test
    public void testConvertSameCurrency() {
        // TODO: Test converting USD to USD should return same amount
        fail("Test not implemented yet");
    }

    @Test
    public void testConvertZeroAmount() {
        // TODO: Test converting 0 amount
        fail("Test not implemented yet");
    }

    @Test
    public void testGetSupportedCurrencies() {
        String[] currencies = converter.getSupportedCurrencies();

        // Exactly the four currencies the specification lists, in the order
        // the exchange-rate table displays them. assertArrayEquals checks the
        // order as well as the contents, which assertTrue(contains) would not.
        assertArrayEquals(new String[]{"USD", "EUR", "GBP", "AUD"}, currencies);
    }

    @Test
    public void testGetSupportedCurrenciesReturnsACopy() {
        // Overwriting the returned array must not change the supported set,
        // otherwise one caller could break the converter for every other one.
        String[] first = converter.getSupportedCurrencies();
        first[0] = "XXX";

        assertEquals("USD", converter.getSupportedCurrencies()[0]);
    }

    @Test
    public void testGetExchangeRate() {
        // Fixed USD rates from the spec; do not round (rounding is display-only).
        assertEquals(0.85, converter.getExchangeRate("USD", "EUR"), 1e-12);
        assertEquals(0.75, converter.getExchangeRate("USD", "GBP"), 1e-12);
        assertEquals(1.30, converter.getExchangeRate("USD", "AUD"), 1e-12);

        // Same currency is always 1.00
        assertEquals(1.00, converter.getExchangeRate("USD", "USD"), 1e-12);
        assertEquals(1.00, converter.getExchangeRate("EUR", "EUR"), 1e-12);
        assertEquals(1.00, converter.getExchangeRate("GBP", "GBP"), 1e-12);
        assertEquals(1.00, converter.getExchangeRate("AUD", "AUD"), 1e-12);

        // Derived: X → Y is (USD → Y) / (USD → X). Do not invert a rounded rate.
        assertEquals(1.0 / 0.85, converter.getExchangeRate("EUR", "USD"), 1e-12);
        assertEquals(1.0 / 0.75, converter.getExchangeRate("GBP", "USD"), 1e-12);
        assertEquals(1.0 / 1.30, converter.getExchangeRate("AUD", "USD"), 1e-12);
        assertEquals(0.75 / 0.85, converter.getExchangeRate("EUR", "GBP"), 1e-12);
        assertEquals(1.30 / 0.75, converter.getExchangeRate("GBP", "AUD"), 1e-12);
        assertEquals(0.85 / 1.30, converter.getExchangeRate("AUD", "EUR"), 1e-12);
    }

    @Test
    public void testConvertAllCurrencyPairs() {
        // TODO: Test conversion between all supported currency pairs
        fail("Test not implemented yet");
    }

    @Test
    public void testRoundToTwoDecimalsRoundsDown() {
        assertEquals(1.23, converter.roundToTwoDecimals(1.234), 1e-9);
    }

    @Test
    public void testRoundToTwoDecimalsRoundsHalfUp() {
        assertEquals(1.01, converter.roundToTwoDecimals(1.005), 1e-9);
        assertEquals(2.69, converter.roundToTwoDecimals(2.685), 1e-9);
    }

    @Test
    public void testRoundToTwoDecimalsLeavesShortValues() {
        assertEquals(67.0, converter.roundToTwoDecimals(67.0), 1e-9);
        assertEquals(100.0, converter.roundToTwoDecimals(100), 1e-9);
    }
}
