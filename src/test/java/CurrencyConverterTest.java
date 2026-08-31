
// src/test/java/CurrencyConverterTest.java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for CurrencyConverter
 */
public class CurrencyConverterTest {

    private CurrencyConverter converter;

    private static class StubCurrencyConverter extends CurrencyConverter {
        private final double exchangeRate;

        StubCurrencyConverter(double exchangeRate) {
            this.exchangeRate = exchangeRate;
        }

        @Override
        public double getExchangeRate(String fromCurrency, String toCurrency) {
            return exchangeRate;
        }
    }

    @BeforeEach
    public void setUp() {
        converter = new CurrencyConverter();
    }

    @Test
    public void testConvertUSDToEUR() {
        converter = new StubCurrencyConverter(0.85);

        assertEquals(85.0, converter.convert(100.0, "USD", "EUR"), 0.000001);
    }

    @Test
    public void testConvertSameCurrency() {
        converter = new StubCurrencyConverter(1.0);

        assertEquals(42.5, converter.convert(42.5, "USD", "USD"), 0.000001);
    }

    @Test
    public void testConvertZeroAmount() {
        converter = new StubCurrencyConverter(0.85);

        assertEquals(0.0, converter.convert(0.0, "USD", "EUR"), 0.000001);
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
