package com.jhdit.java.learning.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * Strings are immutable in Java.
 */

public class StringExamples {
    @Test
    public void stringInitialisationUsingSameStringPoolMemory() {
        // Given: string variable initialisation to same string
        String a = "Hello";
        String b = a;
        String c = "Hello";
        String d = a.intern();

        // Then: all point to (i.e. reference) the exact same object in memory
        assertSame(a, b);
        assertSame(a, c);
        assertSame(a, d);
    }

    @Test
    public void stringInitialisationUsingDifferentStringPoolMemory() {
        // Given: different string variable initialisation approaches using 'new'
        String x = "Hello";
        String y = new String("Hello");
        char[] text = {'H','e','l','l','o'};
        String z = new String(text);

        // Then: all point towards (reference) different objects in memory
        assertNotSame(x,y);
        assertNotSame(x,z);
        assertNotSame(y,z);
    }
}
