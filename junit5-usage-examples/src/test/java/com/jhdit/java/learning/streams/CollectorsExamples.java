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

    private String concatenateViaStream(String[] values) {
        return Arrays.stream(values).collect( Collectors.mapping(s -> s.toString(), Collectors.joining(", ")));
    }

    @Test
    void exploreReduceForCustomAggregation()    {
        // Given: an array of String
        String[] colours  = {"Red", "Yellow", "Green", "Blue"};

        assertEquals("Red, Yellow, Green, Blue", concatenateViaStream(colours));
    }
}
