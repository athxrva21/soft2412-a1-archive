# Currency Converter

## Team

| Member | Unikey | Methods implemented |
| --- | --- | --- |
| 1 Zhengmou Luo | zluo8234 | `convert`, `start`, `isValidCurrency` |
| 2 Xiaoyang Liu | xliu0704 | `getExchangeRate`, `showMenu`, `isValidAmount` |
| 3 Atharva Aher | aahe0438 | `getSupportedCurrencies`, `handleConversion`, `parseAmount` |
| 4 Aditya Mukherjee | amuk0434 | `roundToTwoDecimals`, `showExchangeRates`, `normalizeCurrency` |

Integration-manager repository: https://github.sydney.edu.au/SOFT2412-COMP9412-2026s2/A1-T05-60-IM.git

## Quick Start

```bash
gradle build      # compile and run the tests
gradle run        # run the application
gradle test       # run the tests and write the coverage report
```

Coverage report: `build/reports/jacoco/test/html/index.html`

If `gradle build` fails before you have written any code, that is expected --- the
provided tests fail until you implement the methods they test. To check that your
toolchain works, run `gradle build -x test`.

```bash
make compile      # your Makefile, which you write
make test
make clean
```

## How the work was divided

Four members. Each takes one row of the handout table (three methods, three feature branches).

| Cycle | Tag | Zhengmou | Xiaoyang | Atharva | Aditya |
| --- | --- | --- | --- | --- | --- |
| 1 | v0.2.0 | convert | getExchangeRate | getSupportedCurrencies | roundToTwoDecimals |
| 2 | v0.3.0 | start (+ App.java) | showMenu | parseAmount | showExchangeRates |
| 3 | v1.0.0 | isValidCurrency | isValidAmount | handleConversion | normalizeCurrency |

`parseAmount` was integrated in cycle 2 and `handleConversion` in cycle 3.

## Contributions

------------
name: Zhengmou Luo
unikey: zluo8234
What I did:
Implemented convert (CurrencyConverter), start plus the App entry point (UserInterface) and isValidCurrency (DataValidator), each on its own feature branch with unit tests and a CHANGELOG entry. Integration merge commits: f2535ee (convert), ab1f244 (start) and 303c1b3 (isValidCurrency).

------------
name: Xiaoyang Liu
unikey: xliu0704
What I did:
Implemented getExchangeRate (CurrencyConverter), showMenu (UserInterface) and isValidAmount (DataValidator), each on its own feature branch with unit tests and a CHANGELOG entry. Integration merge commits: 1fc447e (getExchangeRate), 9f77c99 (showMenu) and 3757b8b (isValidAmount).

------------
name: Atharva Aher
unikey: aahe0438
What I did:
Implemented getSupportedCurrencies (CurrencyConverter), handleConversion (UserInterface) and parseAmount (DataValidator), each on its own feature branch with unit tests and a CHANGELOG entry. Integration merge commits: 6553ec3 (getSupportedCurrencies), 02d7929 (parseAmount) and 4ecef36 (handleConversion).

------------
name: Aditya Mukherjee
unikey: amuk0434
What I did:
Implemented roundToTwoDecimals (CurrencyConverter), showExchangeRates (UserInterface) and normalizeCurrency (DataValidator), each on its own feature branch with unit tests and a CHANGELOG entry. Integration merge commits: 5b7b56f (roundToTwoDecimals), 8f85bdf (showExchangeRates) and a9ea2ee (normalizeCurrency).

------------
