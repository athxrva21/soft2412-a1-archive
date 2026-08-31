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
        return amount * getExchangeRate(fromCurrency, toCurrency);
    }

    /**
     * The four currencies the application supports, in the order they appear
     * as the rows and columns of the exchange-rate table.
     *
     * <p>Private and static so there is a single definition of the supported
     * set. It is never handed out directly -- see
     * {@link #getSupportedCurrencies()}.
     */
    private static final String[] SUPPORTED_CURRENCIES = {"USD", "EUR", "GBP", "AUD"};

    /**
     * Get all supported currencies.
     *
     * <p>The order is part of the contract, not an implementation detail: the
     * exchange-rate table is built by iterating this array for both its rows
     * and its columns, so changing the order changes the specified output.
     *
     * <p>A copy is returned rather than the array itself. Arrays are mutable
     * and Java has no way to return a read-only one, so handing out the field
     * would let any caller overwrite the supported set for the whole
     * application.
     *
     * @return the supported currency codes, in display order
     */
    public String[] getSupportedCurrencies() {
        return SUPPORTED_CURRENCIES.clone();
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
