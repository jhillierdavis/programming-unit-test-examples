package com.jhdit.junit5.examples.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Examples (in JUnit5) unit testing a standard Stack (java.util.Stack)
 */

public class StackExamples {

    @DisplayName("stack example: exception handling & multiple when-then blocks")
    @Test
    void checkStackBehaviour()    {
        // setup:
        Stack<Object> stack = new Stack<>(); // Standard Java: java.util.Stack
        Date today = new Date();

        // expect: initialised stack is empty
        assertTrue( stack.empty() );

        // expect: exception is thrown
        // when: when pop from an empty stack
        assertThrows(EmptyStackException.class, stack::pop);

        // when: add various types of entry
        stack.add("First entry");
        // stack.add( Map.of("key1","value1", "key2", "value2") ); // Java 9+C
        stack.add( Stream.of('x', 'y', 'z').collect(Collectors.toList() ) ); // List (in Java 8+)
        stack.add( List.of("alpha", "beta", "gamma", "alpha") ); // List (in Java 9+)
        stack.add( Set.of("foo", "bar", "baz") ); // List (in Java 9+)
        stack.add(today); // Last item

        // then: stack is populated
        assertNotEquals(stack.size(), 0);
        assertEquals(stack.size() , 5 );
        assertSame(stack.peek() , today);
    }

}
