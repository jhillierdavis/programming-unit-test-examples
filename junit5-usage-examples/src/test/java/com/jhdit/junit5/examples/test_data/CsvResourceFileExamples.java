package com.jhdit.junit5.examples.test_data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CSV (Comma Separated Value) source resource file test data examples
 */

public class CsvResourceFileExamples {

    @DisplayName("Check word string input size matches length (using CSV resource file source to provide input test data)")
    @ParameterizedTest(name = "{index} => input={0}, expectedResults={1}")
    @CsvFileSource(resources={"/com/jhdit/junit5/examples/test_words_and_sizes.csv"},  delimiter = '|', numLinesToSkip=1 /* e.g. 1 for header */) // Absolute path NB: Do NOT forget lead forward slash!
    void testWordsFromFileMatchExpectedLength(String inputWord, int expectedLength) {
        assertEquals( inputWord.length() , expectedLength );
    }

}
