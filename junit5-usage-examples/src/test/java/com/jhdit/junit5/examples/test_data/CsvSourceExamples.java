package com.jhdit.junit5.examples.test_data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CSV (Comma Separated Value) source test data examples
 */

public class CsvSourceExamples {

    @DisplayName("Check word string input size matches length (using CSV source to provide input test data)")
    @ParameterizedTest(name = "{index} => input={0}, expectedResults={1}")
    @CsvSource(value={
            "JUnit5|6",
            "Antidisestablishmentarianism|28",
            "Supercalifragilisticexpialidocious|34",
            "Pneumonoultramicroscopicsilicovolcanoconiosis|45"
    },  delimiter = '|')
    void testWordsMatchExpectedLength(String inputWord, int expectedLength) {
        assertEquals( inputWord.length() , expectedLength );
    }
}
