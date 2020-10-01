package com.jhdit.junit5.examples.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Exception handling examples (in JUnit5)
 */

public class ExceptionHandlingExamples {

    @DisplayName("Check appropriate exception thrown (when divide by zero)")
    @Test
    void testExceptionThrown() {
        // Exception expected when perform silly division!
        assertThrows(ArithmeticException.class, () -> {
            int result = 1 / 0;
        });
    }

    @Test
    void shouldThrowException() {
        Throwable exception = assertThrows(UnsupportedOperationException.class, () -> {
            throw new UnsupportedOperationException("Not supported");
        });
        assertEquals(exception.getMessage(), "Not supported");
    }

    @Test
    void assertThrowsException() {
        String str = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Integer.valueOf(str);
        });
    }
}
