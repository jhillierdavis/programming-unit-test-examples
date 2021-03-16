package com.jhdit.java.learning.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * StringBuilder is essentially a mutable equivalent of String.
 */

public class StringBuilderExamples {

    @Test
    public void autoExpansionTest()  {
        // Given: a newly created object
        StringBuilder sb = new StringBuilder();

        // Check: length & default capacity (of 16 chars)
        assertEquals(16, sb.capacity());
        assertEquals(0, sb.length());

        // When: add entries that exceed capacity
        String text = "The quick brown fox jumps over the lazy dog!";
        sb.append(text);

        // Then: capacity has auto-expanded
        assertTrue( sb.capacity() > 16 );
        assertEquals(text.length(), sb.length());
    }

}
