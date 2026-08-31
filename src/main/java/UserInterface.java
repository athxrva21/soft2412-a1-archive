import java.util.Scanner;

/**
 * Console user interface
 *
 * TODO: Implement menu system and user interactions
 * You may divide the following four methods among your team:
 * - start
 * - showMenu
 * - handleConversion
 * - showExchangeRates
 */
public class UserInterface {

    private Scanner scanner;
    private CurrencyConverter converter;
    private DataValidator validator;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.converter = new CurrencyConverter();
        this.validator = new DataValidator();
    }

    /**
     * Start the main application loop
     */
    public void start() {
        // TODO: Implement main menu loop
        // 1. Show menu
        // 2. Get user choice
        // 3. Handle choice
        // 4. Repeat until exit

        System.out.println("=== Currency Converter ===");
        // TODO: Implement menu loop
    }

    /**
     * Display main menu options
     */
    public void showMenu() {
        // TODO: Display menu:
        // 1. Convert Currency
        // 2. View Exchange Rates
        // 3. Exit
    }

    /**
     * Handle currency conversion process
     */
    public void handleConversion() {
        // TODO: Guide user through conversion:
        // 1. Get amount
        // 2. Get source currency
        // 3. Get target currency
        // 4. Show result
    }

    /**
     * Display exchange rates table
     */
    public void showExchangeRates() {
        String[] currencies = converter.getSupportedCurrencies();
        System.out.println("Exchange Rates (base = 1 unit)");

        StringBuilder header = new StringBuilder();
        for (String currency : currencies) {
            header.append("\t").append(currency);
        }
        System.out.println(header.toString());

        for (String from : currencies) {
            StringBuilder row = new StringBuilder(from);
            for (String to : currencies) {
                double rate = converter.getExchangeRate(from, to);
                row.append("\t").append(String.format("%.2f", rate));
            }
            System.out.println(row.toString());
        }
    }
}
