package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

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
        assertEquals(6, Arrays.stream(colours).mapToInt(String::length).max().getAsInt());
        assertEquals(3, Arrays.stream(colours).mapToInt(String::length).min().getAsInt());
        // Obtain min/max baed on alphabetical ordering
        assertEquals("Yellow", Arrays.stream(colours).max(String::compareTo).get());
        assertEquals("Blue", Arrays.stream(colours).min(String::compareTo).get());

    }

    @Test
    void exploreAggregateOperationsOnEmptyArray()    {
        // Given: an empty array of String
        String[] empty  = {};

        // Then: use stream aggregate operations results in exception being thrown
        assertThrows(NoSuchElementException.class, () -> Arrays.stream(empty).mapToInt(String::length).max().getAsInt());
        assertThrows(NoSuchElementException.class, () -> {
            assertEquals(3, Arrays.stream(empty).mapToInt(String::length).min().getAsInt());
        });
    }

    private String concatenateViaStream(String[] values) {
        return Arrays.stream(values).map(String::toString).reduce((s1,s2) -> s1 + " " + s2).get();
    }

    private String concatenateViaParallelStream(String[] values) {
        return Arrays.stream(values).parallel().map(String::toString).reduce((s1,s2) -> s1 + " " + s2).get();
    }

    private String concatenateViaStreamWithDefaultInitialValue(String[] values, String initialValue) {
        return Arrays.stream(values).map(String::toString).reduce(initialValue, (s1,s2) -> s1 + " " + s2);
    }

    private String concatenateViaCollectors(String[] values) {
        return Arrays.stream(values).collect( Collectors.mapping(s -> s.toString(), Collectors.joining(" ")));
    }


    @Test
    void exploreReduceForCustomAggregation()    {
        // Given: an array of String
        String[] colours  = {"Red", "Yellow", "Green", "Blue"};

        // Then: concatenation can be performed using Streams in various ways e.g.:
        assertEquals("Red Yellow Green Blue", concatenateViaStream(colours));
        assertEquals("Red Yellow Green Blue", concatenateViaParallelStream(colours));
        assertEquals("Purple Red Yellow Green Blue", concatenateViaStreamWithDefaultInitialValue(colours, "Purple"));
        assertEquals("Red Yellow Green Blue", concatenateViaCollectors(colours)); // See @CollectorsExamples for more
    }
}
