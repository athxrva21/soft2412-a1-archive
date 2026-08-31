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
     * Guide the user through one conversion: read an amount, read the two
     * currency codes, and print the result.
     *
     * <p>The order in which input is validated is specified behaviour, not an
     * implementation detail:
     *
     * <ul>
     *   <li>the amount is checked as soon as it is read, so an invalid amount
     *       returns to the menu without asking for currencies at all;</li>
     *   <li>both currency codes are read before either is checked, so an
     *       invalid "from" code still prompts for the "to" code before the
     *       error appears.</li>
     * </ul>
     *
     * <p>Codes are normalized before being validated, so "usd", "USD" and
     * " Usd " are the same currency, and the normalized form is what appears
     * in the result line. Rounding happens only here, at display time.
     *
     * <p>No blank line is printed before or after this output. The blank lines
     * that separate an operation from the menu belong to {@link #start()},
     * which is the only place that knows a menu choice has just been read.
     */
    public void handleConversion() {
        System.out.print("Enter amount: ");
        String amountInput = scanner.nextLine();

        if (!validator.isValidAmount(amountInput)) {
            System.out.println("Invalid amount. Enter a positive number.");
            return;
        }

        System.out.print("From currency (USD/EUR/GBP/AUD): ");
        String fromInput = scanner.nextLine();
        System.out.print("To currency (USD/EUR/GBP/AUD): ");
        String toInput = scanner.nextLine();

        String from = validator.normalizeCurrency(fromInput);
        String to = validator.normalizeCurrency(toInput);

        if (!validator.isValidCurrency(from) || !validator.isValidCurrency(to)) {
            System.out.println("Invalid currency. Use USD, EUR, GBP or AUD.");
            return;
        }

        double amount = validator.parseAmount(amountInput);
        double converted = converter.convert(amount, from, to);

        System.out.printf("Result: %.2f %s = %.2f %s%n", amount, from, converted, to);
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
