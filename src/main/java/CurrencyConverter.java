/**
 * Core currency conversion logic
 *
 * TODO: Implement conversion calculations and exchange rate management
 * You may distribute four of the following methods among your team:
 * - convert
 * - getSupportedCurrencies
 * - getExchangeRate
 * - roundToTwoDecimals
 */
public class CurrencyConverter {

    /**
     * Convert amount from one currency to another
     * @param amount amount to convert
     * @param fromCurrency source currency (USD/EUR/GBP/AUD)
     * @param toCurrency target currency (USD/EUR/GBP/AUD)
     * @return converted amount
     */
    public double convert(double amount, String fromCurrency, String toCurrency) {
        // TODO: Implement conversion logic
        // Use hardcoded exchange rates:
        // USD -> EUR: 0.85, USD -> GBP: 0.75, USD -> AUD: 1.30
        // EUR -> USD: 1.18, GBP -> USD: 1.33, AUD -> USD: 0.77
        // Calculate other rates as needed

        return 0.0; // Replace with actual calculation
    }

    /**
     * Get all supported currencies
     * @return array of currency codes
     */
    public String[] getSupportedCurrencies() {
        // TODO: Return array of supported currencies
        return new String[]{};
    }

    /**
     * Get exchange rate between two currencies
     * @param fromCurrency source currency
     * @param toCurrency target currency
     * @return exchange rate
     */
    public double getExchangeRate(String fromCurrency, String toCurrency) {
        // TODO: Return exchange rate between currencies
        return 0.0; // Replace with actual rate
    }

    /**
     * Round a double value to two decimal places using standard rounding
     * @param value the value to round
     * @return rounded value
     */
    public double roundToTwoDecimals(double value) {
        // TODO: Round the value to two decimal places
        return 0.0; // Replace with actual rounding
    }
}
