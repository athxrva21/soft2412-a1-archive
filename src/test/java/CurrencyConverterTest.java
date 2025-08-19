
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
        // TODO: Test that getSupportedCurrencies returns correct array
        // Should contain ["USD", "EUR", "GBP", "AUD"]
        fail("Test not implemented yet");
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
