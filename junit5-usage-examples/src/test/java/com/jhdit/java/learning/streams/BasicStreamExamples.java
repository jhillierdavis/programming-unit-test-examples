package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicStreamExamples {
    @Test
    void explore()  {
        // Given: an immutable list of string
        List<String> names = List.of("Barclay", "Barry", "Bert", "Bort");

        // When: match using findAny() which returns an Optional<String> we set empty to the value 'Not found!"
        String match = names.stream().filter(n -> n.contains("Bart")).findAny().orElse("Not found!");

        // Expect: not found for the test values
        assertEquals("Not found!", match);
    }
}
