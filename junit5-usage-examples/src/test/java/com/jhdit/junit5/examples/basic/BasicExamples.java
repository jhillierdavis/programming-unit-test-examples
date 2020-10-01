package com.jhdit.junit5.examples.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic JUnit5 examples
 */

public class BasicExamples {

    @DisplayName("Super simple logic example (basic multiplication)")
    @Test  void basicMultiplication() {
        assertEquals( 3 * 7 , 21);
    }

    @Test
    @DisplayName("Use lambdas in assertions")
    void lambdaExpressions() {
        assertTrue(Stream.of(1, 2, 3)
                .mapToInt(i -> i)
                .sum() > 5, "Sum should be greater than 5");
    }

    @Test
    void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 0),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 4)
        );
    }
}
