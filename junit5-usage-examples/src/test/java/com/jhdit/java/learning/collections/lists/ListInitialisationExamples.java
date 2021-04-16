package com.jhdit.java.learning.collections.lists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Examples of list initialisation (producing both immutable & mutable lists)
 */

public class ListInitialisationExamples {

    @Test
    void initialiseImmutableList() {
        // Given: an list initialised from via Arrays
        List<String> list = Arrays.asList("foo", "bar");

        // Then: list is as expected
        assertEquals(2, list.size());
        assertTrue(list.contains("foo"));
        assertEquals("java.util.Arrays$ArrayList", list.getClass().getName());

        // But: cannot be modified (i.e. immutable)
        assertThrows(UnsupportedOperationException.class, () -> {
            list.add("baz");
        });
    }

    @Test
    void initialiseImmutableListSinceJava9() {
        // Given: an list initialised from List.of (Java 9+)
        List<String> list = List.of("foo", "bar");

        // Then: list is as expected
        assertEquals(2, list.size());
        assertTrue(list.contains("foo"));
        assertEquals("java.util.ImmutableCollections$List2", list.getClass().getName());

        // But: cannot be modified (i.e. immutable)
        assertThrows(UnsupportedOperationException.class, () -> {
            list.add("baz");
        });
    }

    @Test
    void initialiseMutableListViaStream() {
        List<String> list = Stream.of("foo", "bar").collect(Collectors.toList());

        // Then: list is as expected
        assertEquals(2, list.size());
        assertTrue(list.contains("foo"));
        assertEquals("java.util.ArrayList", list.getClass().getName());

        // And: list is mutable
        list.add("baz");
        assertEquals(3, list.size());
        assertTrue(list.contains("baz"));
    }

    @Test
    void initialiseMutableListTheVerboseWay() {
        List<String> list = new ArrayList<>();
        list.add("foo");
        list.add("bar");

        // Then: list is as expected
        assertEquals(2, list.size());
        assertTrue( list.containsAll( Stream.of("foo", "bar").collect(Collectors.toList()) ) );
        assertEquals("java.util.ArrayList", list.getClass().getName());

        // And: list is mutable
        list.add("baz");
        assertEquals(3, list.size());
        assertTrue(list.containsAll(Stream.of("foo", "bar", "baz").collect(Collectors.toList())));
    }
}


