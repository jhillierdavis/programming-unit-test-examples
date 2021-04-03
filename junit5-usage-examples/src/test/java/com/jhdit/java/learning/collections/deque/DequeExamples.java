package com.jhdit.java.learning.collections.deque;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Ref.: https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/Deque.html
 */

public class DequeExamples {

    @Test
    public void exploreDequeOperations()  {
        // Given a (standard) Java Deque implementation (NB: Deque is abstract)
        Deque<String> deque = new LinkedList<>();
        assertEquals(0, deque.size());

        // When: populated
        deque.add("Two");
        deque.add("Three");
        assertEquals(2, deque.size());

        // Then: peek() obtains the first entry, but does not remove it.
        String first = deque.peek(); // or use peekFirst()
        assertEquals("Two", first);

        // Then: peekLast() obtains the last entry, but does not remove it.
        String last = deque.peekLast();
        assertEquals("Three", last);
        assertEquals(2, deque.size());

        // Then: offerFirst() adds a new first entry (returning True if successful)
        assertTrue(deque.offerFirst("One"));
        first = deque.peek();
        assertEquals("One", first);
        assertEquals(3, deque.size());

        // Then: offer(), or offerLast(), adds a new last entry (returning True if successful)
        assertTrue(deque.offer("Four"));
        last = deque.peekLast();
        assertEquals("Four", last);
        assertEquals(4, deque.size());
    }
}
