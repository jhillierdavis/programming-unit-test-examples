package com.jhdit.java.learning.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        // Given: different string variable initialisation approaches using 'new' (NOT recommended however typically)
        String x = "Hello";
        String y = new String("Hello");
        char[] text = {'H','e','l','l','o'};
        String z = new String(text);

        // Then: all point towards (reference) different objects in memory
        assertFalse(x == y);
        assertNotSame(x,y);
        assertNotSame(x,z);
        assertNotSame(y,z);

        // However: if use intern() then can obtain same (canonical) reference to "Hello" (from String pool)
        String internStr = z.intern();
        assertTrue(internStr == x);
    }

    @Test
    public void stringIndexing() {
        // Given: a test string
        String str = "Echo Echo!";

        // Then: can index chars
        assertEquals(0, str.indexOf('E')); // Find index of first occurrence (from start char)
        assertEquals(5, str.indexOf('E', 1)); // Find index of first occurrence, starting from offset
        assertEquals(5, str.lastIndexOf('E')); // Find index of last occurrence (e.g. search backward: right to left
        assertEquals('!', str.charAt( str.length() - 1)); // Obtain last char
    }

    @Test
    public void stringConvenienceMethods()  {
        // Example: use toUpperCase() and toLowerCase()
        assertEquals("SHOUT", "shout".toUpperCase());
        assertEquals("whisper", "WHISPER".toLowerCase());

        // Example: substring
        assertEquals("round", "surrounded".substring(3,8)); // NB: start index is included, end index is excluded

        // Example: capitalise using substring(), toUpperCase() & toLowerCase()
        String title = "dOcToR";
        assertEquals("Doctor", title.substring(0,1).toUpperCase() + title.substring(1).toLowerCase());
    }

    @Test
    public void splitOnSpace() {
        String[] strArray = "A set of words!".split(" ");

        assertEquals(4, strArray.length);
        assertEquals("A", strArray[0]);
        assertEquals("words!", strArray[3]);
    }

    @Test
    public void splitOnComma() {
        String[] strArray = "Alpha,Beta,Gamma".split(",");

        assertEquals(3, strArray.length);
        assertEquals("Alpha", strArray[0]);
        assertEquals("Gamma", strArray[2]);
    }
}
