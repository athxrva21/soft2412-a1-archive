
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

        // Unsupported codes hit usdTo's default. The UI never asks for a rate
        // of an invalid code, but the line must still run for full coverage.
        assertEquals(0.0, converter.getExchangeRate("USD", "XXX"), 1e-12);
    }

    @Test
    public void testConvertAllCurrencyPairs() {
        String[] currencies = {"USD", "EUR", "GBP", "AUD"};
        double[] usdRates = {1.0, 0.85, 0.75, 1.30};
        double amount = 100.0;

        for (int from = 0; from < currencies.length; from++) {
            for (int to = 0; to < currencies.length; to++) {
                double expectedRate = usdRates[to] / usdRates[from];
                double expectedAmount = amount * expectedRate;

                assertEquals(
                    expectedAmount,
                    converter.convert(amount, currencies[from], currencies[to]),
                    1e-12,
                    currencies[from] + " to " + currencies[to]
                );
            }
        }
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
