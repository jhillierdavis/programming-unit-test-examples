package com.jhdit.java.learning.collections.deque;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class FifoQueueExamples {

    @Test
    void explore()  {
        // Given: an initialised queue
        // Queue<String> q = new LinkedList<>();
        Queue<String> q = new ArrayDeque<>();
        q.offer("Alpha"); // or add()
        q.offer("Beta");
        q.offer("Gamma");

        // Then: the queue can behave as a FIFO (First-In-First-Out) collection
        assertEquals(3, q.size());
        assertEquals("Alpha", q.peek());
        assertEquals("Alpha", q.poll());
        assertEquals("Beta", q.peek());
        assertEquals("Beta", q.poll());
        assertEquals("Gamma", q.peek());
        assertEquals("Gamma", q.poll());
        assertNull(q.peek());
    }
}
