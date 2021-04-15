package com.jhdit.java.learning.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Explore creation of Strings (in String pool vs Heap memory)
 */

public class StringCreationExamples {

    @Test
    void exploreStringPoolVsHeap()  {
        String s1 = "Creation"; // Points to String pool (in memory)
        String s2 = new String(s1); // Object on the heap (in memory) - so refers to different object from s1
        String s3 = "Creation"; // Points to String pool (in memory) - so refers to same object as s1

        // Then: all are equally (same content)
        assertTrue(s1.equals(s2));
        assertTrue(s1.equals(s3));


        // But: s2 is a different object than s1 (& s3)
        assertFalse(s1 == s2);
        assertTrue(s1 == s3);

        // However: can use 'intern()' to get same String instance (canonical representation from String pool)
        assertTrue(s1 == s2.intern());
    }
}
