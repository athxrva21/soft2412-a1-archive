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
        // TODO: Validate currency is one of: USD, EUR, GBP, AUD
        return false; // Replace with validation logic
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
     * Parse amount string to double
     * @param amountStr string to parse
     * @return parsed amount or 0.0 if invalid
     */
    public double parseAmount(String amountStr) {
        // TODO: Safely parse string to double
        return 0.0; // Replace with parsing logic
    }

    /**
     * Normalize currency code (uppercase, trim)
     * @param currency raw currency input
     * @return normalized currency code
     */
    public String normalizeCurrency(String currency) {
        // TODO: Clean up currency input (trim, uppercase)
        return currency; // Replace with normalization
    }
}
