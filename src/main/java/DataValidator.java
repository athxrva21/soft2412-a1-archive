/**
 * Input validation utilities
 *
 * TODO: Implement validation methods for user input
 */
public class DataValidator {

    /**
     * Check if currency code is valid
     * @param currency currency code to validate
     * @return true if valid (USD/EUR/GBP/AUD)
     */
    public boolean isValidCurrency(String currency) {
        if (currency == null) {
            return false;
        }

        String normalizedCurrency = currency.trim();
        return normalizedCurrency.equalsIgnoreCase("USD")
            || normalizedCurrency.equalsIgnoreCase("EUR")
            || normalizedCurrency.equalsIgnoreCase("GBP")
            || normalizedCurrency.equalsIgnoreCase("AUD");
    }

    /**
     * Check if amount string is valid
     * @param amountStr string representation of amount
     * @return true if valid positive number
     */
    public boolean isValidAmount(String amountStr) {
        // TODO: Check if string represents positive number
        return false; // Replace with validation logic
    }

    /**
     * Parse an amount string to a double, returning 0.0 rather than throwing
     * when the string is not a usable amount.
     *
     * <p>Three inputs that {@link Double#parseDouble(String)} does not handle
     * the way this method needs are dealt with explicitly:
     *
     * <ul>
     *   <li>null, which makes {@code Double.parseDouble} throw a
     *       {@link NullPointerException} rather than the
     *       {@link NumberFormatException} the catch below is for;</li>
     *   <li>surrounding whitespace, which a value typed at the menu can carry;</li>
     *   <li>"NaN" and "Infinity", which parse successfully but are not amounts.
     *       Returning one would carry it through the conversion and print it as
     *       the result.</li>
     * </ul>
     *
     * <p>Whether the amount is positive is not decided here --- that is
     * {@link #isValidAmount(String)}'s job. This method only converts.
     *
     * @param amountStr string to parse, possibly null or malformed
     * @return the parsed amount, or 0.0 if the string is not a usable number
     */
    public double parseAmount(String amountStr) {
        if (amountStr == null) {
            return 0.0;
        }

        try {
            double amount = Double.parseDouble(amountStr.trim());
            return Double.isFinite(amount) ? amount : 0.0;
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    /**
     * Normalize currency code (uppercase, trim)
     * @param currency raw currency input
     * @return normalized currency code
     */
    public String normalizeCurrency(String currency) {
        if (currency == null) {
            return null;
        }
        return currency.trim().toUpperCase();
    }
}
