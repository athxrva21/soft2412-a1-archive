# Changelog

## Unreleased

- isValidCurrency(): accepts supported codes regardless of case or surrounding whitespace -- Zhengmou Luo
- handleConversion(): prompts for an amount and two currencies, validates them and prints the result -- Atharva
- normalizeCurrency(): trims and uppercases a currency code, null-safe -- amuk0434
- showMenu(): displays the main menu options -- Xiaoyang Liu
- start(): runs the menu loop and App entry point until Exit is chosen -- Zhengmou Luo
- parseAmount(): converts an amount string to a double, or 0.0 if it is not a usable number -- Atharva
- showExchangeRates(): prints the full rate table for all currency pairs -- amuk0434
- testConvertAllCurrencyPairs(): covers all sixteen supported currency pairs and prepares v0.2.1 -- Zhengmou Luo
- convert(): converts an amount using the requested exchange rate -- zluo8234
- getExchangeRate(): returns the rate between two currencies from the three fixed USD rates -- Xiaoyang Liu
- roundToTwoDecimals(): rounds a value to two decimal places (HALF_UP) -- amuk0434
- getSupportedCurrencies(): returns the four supported currency codes in display order -- Atharva

<!--
Add one line here for each feature branch, newest at the top, like:

- convert(): converts an amount between two currencies -- <your name>

Everyone adds lines to the same place, so merges here will sometimes
conflict. Keep both lines, delete the <<<<<<< / ======= / >>>>>>> markers,
then `git add CHANGELOG.md` and commit the merge.
-->
