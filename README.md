# Currency Converter

## Team

| Member | Unikey | Methods implemented |
| --- | --- | --- |
| 1 Zhengmou Luo | zluo8234 | `convert`, `start`, `isValidCurrency` |
| 2 Xiaoyang Liu | xliu0704 | `getExchangeRate`, `showMenu`, `isValidAmount` |
| 3 Atharva Aher | | `getSupportedCurrencies`, `handleConversion`, `parseAmount` |
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

Four members. Each takes one row of the handout table (three methods, three feature branches). Hong is not on this assignment.

| Cycle | Tag | Member 1 Zhengmou | Member 2 Xiaoyang | Member 3 Atharva | Member 4 Aditya |
| --- | --- | --- | --- | --- | --- |
| 1 | v0.2.0 | convert | getExchangeRate | getSupportedCurrencies | roundToTwoDecimals |
| 2 | v0.3.0 | start (+ App.java) | showMenu | handleConversion | showExchangeRates |
| 3 | v1.0.0 | isValidCurrency | isValidAmount | parseAmount | normalizeCurrency |

## What I personally implemented

Xiaoyang Liu (`xliu0704`): `getExchangeRate`, `showMenu`, `isValidAmount`.

Aditya Mukherjee (`amuk0434`): `roundToTwoDecimals`, `showExchangeRates`, `normalizeCurrency`.
