package com.jhdit.java.learning.locale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.NumberFormat;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocaleCurrencyFormattingExamples {

    @ParameterizedTest(name = "{index} => inputCurrency={0}, expectedResults={1}")
    @CsvSource(value={
            "UK|£27.89",
            "US|$27.89",
    },  delimiter = '|')
    public void localeSpecificCurrency(String inputCurrency, String expectedResult)    {
        // Setup: set locale (based on input)
        Locale locale;
        switch (inputCurrency) {
            case "US":
                locale = Locale.US;
                break;

            case "UK":
                locale = Locale.UK;
                break;

            default:
                locale = Locale.getDefault();
        }

        // When: currency formatter is initialised based on the specified locale
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

        // Then: financial values are formatted in the appropriate currency (e.g. GBP or USD)
        assertEquals(expectedResult, currencyFormat.format(27.89));
    }
}
