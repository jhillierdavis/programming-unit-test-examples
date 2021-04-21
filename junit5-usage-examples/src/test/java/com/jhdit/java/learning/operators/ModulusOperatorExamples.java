package com.jhdit.java.learning.operators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ModulusOperatorExamples {

    @Test
    void explore()  {
        assertEquals(0, 0 % 2);
        assertEquals(0, 2 % 2);
        assertEquals(0, 4 % 2);
        assertEquals(0, 16 % 2);
        assertEquals(0, 0 % 2);
        assertEquals(0, -2 % 2);
        assertEquals(0, -4 % 2);
        assertEquals(0, -16 % 2);

        assertEquals(1, 1 % 2);
        assertEquals(-1, -1 % 2);
        assertEquals(1, 3 % 2);
        assertEquals(-1, -3 % 2);
        assertEquals(1, 5 % 2);
        assertEquals(-1, -5 % 2);
        assertEquals(1, 17 % 2);
        assertEquals(-1, -17 % 2);

        assertEquals(-1, -1 % 3);
        assertEquals(1, 1 % 3);
        assertEquals(2, 2 % 3);
        assertEquals(-2, -2 % 3);
        assertEquals(1, 10 % 3);
        assertEquals(-1, -10 % 3);
        assertEquals(2, 29 % 3);
        assertEquals(-2, -29 % 3);
    }

    @Test
    void exploreInvalid()   {
        assertThrows(ArithmeticException.class, () -> {
            var result = 3 % 0;
        });
    }
}
