package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Collectors (see @java.util.stream.Collectors) examples for Java Streams.
 *
 * Predefined implementations of the Collector interface (supplied by the Collectors class)
 */

public class CollectorsExamples {

    private String concatenateValues(String[] values) {
        return Arrays.stream(values).collect( Collectors.mapping(s -> s.toString(), Collectors.joining(", ")));
    }

    @Test
    void exploreCollectorsMapping()    {
        // Given: an array of String
        String[] colours  = {"Red", "Yellow", "Green", "Blue"};

        assertEquals("Red, Yellow, Green, Blue", concatenateValues(colours));
    }

    private long countResults(String[] values)    {
        return Arrays.stream(values).collect( Collectors.summarizingInt( s -> s.length() ) ).getCount();
    }

    private long totalLength(String[] values)    {
        return Arrays.stream(values).collect( Collectors.summarizingInt( s -> s.length() ) ).getSum();
    }

    private int maxLength(String[] values) {
        return Arrays.stream(values).collect( Collectors.summarizingInt( s -> s.length() ) ).getMax();
    }

    private int minLength(String[] values) {
        return Arrays.stream(values).collect( Collectors.summarizingInt( s -> s.length() ) ).getMin();
    }

    private double meanLength(String[] values) {
        return Arrays.stream(values).collect( Collectors.summarizingInt( s -> s.length() ) ).getAverage();
    }

    @Test
    void exploreCollectorsSummarising()    {
        // Given: an array of String
        String[] colours  = {"Red", "Yellow", "Green", "Blue"};

        // Then: summarising aggregations can be preformed (e.g. sum, min, max)
        assertEquals(4, countResults(colours));
        assertEquals(18, totalLength(colours));
        assertEquals(6, maxLength(colours));
        assertEquals(3, minLength(colours));
        assertEquals(4.5, meanLength(colours));
    }
}
