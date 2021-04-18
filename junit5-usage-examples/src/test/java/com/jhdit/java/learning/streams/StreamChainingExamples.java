package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Examples of stream chaining.
 */

public class StreamChainingExamples {

    @Test
    void verbose()  {
        // Setup: a string list
        List<String> list = getStringList();

        // Given: a stream from list
        Stream<String> stream = list.stream();

        // When: zero or more non-terminal operations can be performed
        Stream<String> reverseStream = stream.map( s -> new StringBuilder(s).reverse().toString());
        Stream<String> uppercaseStream = reverseStream.map(String::toUpperCase);

        // Then: a terminal operation
        uppercaseStream.forEach(s -> assertTrue(s.endsWith("TNEMELE"))); // ends with 'ELEMENT' backwards
    }

    @Test
    void methodChainingVersion()  {
        // Given: a string list
        List<String> list = getStringList();

        // Then: process as a stream (getting rid of intermediary variables compared to 'verbose' example)
        list.stream()
                .map(s -> new StringBuilder(s).reverse().toString())
                .map(String::toUpperCase)
                .forEach(s -> assertTrue(s.endsWith("TNEMELE")));
    }

    @Test
    void streamCannotBeReprocessed()    {
        // Setup: a string list
        List<String> list = getStringList();

        // Given: a stream from list
        Stream<String> stream = list.stream();

        // When: zero or more non-terminal operations can be performed
        Stream<String> reverseStream = stream.map( s -> new StringBuilder(s).reverse().toString());

        // Then: stream has already been operated upon or closed
        assertThrows(IllegalStateException.class, () -> {
                    stream.map(String::toUpperCase);
                }
        );

        // NB: should instead chain to 'reverseStream' to continue existing steam processing
    }

    private List<String> getStringList() {
        List<String> list = new ArrayList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");
        return list;
    }
}
