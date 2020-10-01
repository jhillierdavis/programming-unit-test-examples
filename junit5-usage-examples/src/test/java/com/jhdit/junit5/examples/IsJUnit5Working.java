package com.jhdit.junit5.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Simple Unit test/specification to confirm JUnit5 test framework is functioning correctly
 * (&amp; for quick reference).
 */

public class IsJUnit5Working {

    @Test
    void testWordMatchesExpectedLength()   {
        assertEquals("JUnit5".length(), 6);
    }

    @DisplayName("Check word string input size matches length (single example)")
    @ParameterizedTest
    @ValueSource(strings = { "Hello!", "JUnit5" })
    void testWordsMatchExpectedLength(String word)   {
        assertEquals(word.length(), 6);
    }

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

    @DisplayName("Check word string input size matches length (using CSV resource file source to provide input test data)")
    @ParameterizedTest(name = "{index} => input={0}, expectedResults={1}")
//  @CsvFileSource(resources={"/com/jhdit/junit5/examples/test_words_and_sizes.csv"},  delimiter = '|', numLinesToSkip=1 /* e.g. 1 for header */) // Absolute path NB: Do NOT forget lead forward slash!
    @CsvFileSource(resources={"test_words_and_sizes.csv"},  delimiter = '|', numLinesToSkip=1 /* e.g. 1 for header */) // Relative path
    void testWordsFromFileMatchExpectedLength(String inputWord, int expectedLength) {
        assertEquals( inputWord.length() , expectedLength );
    }


    /**
     * Exception handling example
     */
    @DisplayName("Check exception thrown (when divide by zero)")
    @Test void testExceptionThrown() {
        // Exception expected when perform silly division!
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int result = 1 / 0;
        });
    }

    /**
     * Test exclusion example
     */

    @Disabled(value = "TODO")
    @Test
    void ignoreForNow() {
        assertEquals(true, false);
    }
}
