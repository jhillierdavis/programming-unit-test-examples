package com.jhdit.java.learning.collections.deque;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Use push() to behave as a Stack (i.e. LILO - last In Last out)
 */


public class LiloQueueExamples {
    @Test
    void exploreStackBehaviour()  {
        // Given: an initialised queue
        Deque<String> q = new ArrayDeque<>();
        q.push("Alpha");
        q.push("Beta");
        q.push("Gamma");

        // Then: the queue can behave as a FIFO (First-In-First-Out) collection
        assertEquals(3, q.size());
        assertEquals("Gamma", q.peek());
        // assertEquals("Gamma", q.pop());
        assertEquals("Gamma", q.poll());
        assertEquals("Beta", q.peek());
        assertEquals("Beta", q.pop());
        assertEquals("Alpha", q.peek());
        assertEquals("Alpha", q.pop());
        assertNull(q.peek());
    }
}
