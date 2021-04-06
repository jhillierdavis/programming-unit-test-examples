package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Collectors (see @java.util.stream.Collectors) examples for Java Streams.
 *
 * Predefined implementations of the Collector interface (supplied by the Collectors class)
 */

public class CollectorsExamples {
    private String[] colours  = {"Red", "Yellow", "Green", "Blue"}; // Some test values

    private String concatenateValues(String[] values) {
        return Arrays.stream(values).collect( Collectors.mapping(s -> s.toString(), Collectors.joining(", ")));
    }

    @Test
    void exploreCollectorsMapping()    {
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

    private String meanLengthAsString(String[] values) {
        // example of use of Collectors.collectingAndThen
        return Arrays.stream(values).collect(
                    Collectors.collectingAndThen(
                        Collectors.summarizingInt(s -> s.length() ),
                        n -> "The average (mean) value is " + n.getAverage()
                    )
                );
    }

    @Test
    void exploreCollectorsSummarising()    {
        // Check: summarising aggregations can be preformed (e.g. sum, min, max)
        assertEquals(4, countResults(colours));
        assertEquals(18, totalLength(colours));
        assertEquals(6, maxLength(colours));
        assertEquals(3, minLength(colours));
        assertEquals(4.5, meanLength(colours));
        assertEquals("The average (mean) value is 4.5", meanLengthAsString(colours));
    }

    @Test
    void exploreCollectorsGathering()   {
        // When: a filtering is applied & collected
        List<String> results = Arrays.stream(colours).filter(s -> s.toLowerCase().contains("r") ).collect(Collectors.toList());

        // Then: results list is as expected (for test values)
        assertEquals(2, results.size());
        assertTrue(results.contains("Red"));
        assertTrue(results.contains("Green"));
    }
}
