
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
        // TODO: Test getting exchange rate between two currencies
        fail("Test not implemented yet");
    }

    @Test
    public void testConvertAllCurrencyPairs() {
        // TODO: Test conversion between all supported currency pairs
        fail("Test not implemented yet");
    }
}
