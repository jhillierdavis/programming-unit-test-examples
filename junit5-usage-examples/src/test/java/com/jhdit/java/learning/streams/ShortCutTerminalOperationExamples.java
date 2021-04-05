package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Stream short-cut terminal operations examples
 *
 * which produce finite output even if presented with infinite input.
 */


public class ShortCutTerminalOperationExamples {

    @Test
    void exploreTerminalOperations()    {
        // Given: an array of String
        String[] colours  = {"Red", "Yellow", "Green", "Blue"};

        // Then: use streams terminal operations to check conditions
        assertFalse(Arrays.stream(colours).allMatch(s -> s.equals("Red")));
        assertFalse(Arrays.stream(colours).anyMatch(s -> s.equals("Purple")));
        assertFalse(Arrays.stream(colours).noneMatch(s -> s.equals("Blue")));
        assertTrue(Arrays.stream(colours).anyMatch(s -> s.equals("Yellow")));
        assertTrue(Arrays.stream(colours).noneMatch(s -> s.equals("Purple")));

        Optional<String> optional = Arrays.stream(colours).findFirst();
        if (!optional.isPresent()) {
            fail("Failed to find expected first test value!");
        }
        assertEquals("Red", optional.get()); // NB: Unpredictable if obtained via parallel

        optional = Arrays.stream(colours).findAny();
        if (!optional.isPresent()) {
            fail("Failed to find expected test value!");
        }
    }
}
