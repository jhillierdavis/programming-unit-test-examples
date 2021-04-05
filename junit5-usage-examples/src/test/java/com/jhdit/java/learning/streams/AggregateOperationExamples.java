package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Java Stream aggregate operation examples (e.g. count, sum, average, min, max)
 */

public class AggregateOperationExamples {

    @Test
    void exploreAggregateOperations()    {
        // Given: an array of String
        String[] colours  = {"Red", "Yellow", "Green", "Blue"};

        // Then: use stream aggregate operations
        assertEquals(1, Arrays.stream(colours).filter(s -> s.indexOf('R') != -1).count());
        assertEquals(2, Arrays.stream(colours).filter(s -> s.toLowerCase().indexOf('r') != -1).count());
        assertEquals(18, Arrays.stream(colours).mapToInt(String::length).sum());
        OptionalDouble optionalMeanLength = Arrays.stream(colours).mapToInt(String::length).average();
        assertEquals(4.5, optionalMeanLength.isPresent() ? optionalMeanLength.getAsDouble() : 0);
        OptionalInt optionalInt = Arrays.stream(colours).mapToInt(String::length).max();
        assertEquals(6, optionalInt.isPresent() ? optionalInt.getAsInt() : 0);
        optionalInt = Arrays.stream(colours).mapToInt(String::length).min();
        assertEquals(3, optionalInt.isPresent() ? optionalInt.getAsInt() : 0);
    }
}
