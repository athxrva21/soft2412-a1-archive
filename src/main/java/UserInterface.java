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
        boolean running = true;

        while (running) {
            System.out.println("=== Currency Converter ===");
            showMenu();
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    handleConversion();
                    break;
                case "2":
                    showExchangeRates();
                    break;
                case "3":
                    System.out.println("Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Enter 1, 2 or 3.");
                    break;
            }
        }
    }

    /**
     * Display main menu options
     */
    public void showMenu() {
        System.out.println("=== Currency Converter ===");
        System.out.println("1. Convert Currency");
        System.out.println("2. View Exchange Rates");
        System.out.println("3. Exit");
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
