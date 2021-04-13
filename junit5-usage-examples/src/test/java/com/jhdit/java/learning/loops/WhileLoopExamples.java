package com.jhdit.java.learning.loops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WhileLoopExamples {

    @Test
    void explore()  {
        // Setup:
        int x = 0;

        // Given: incremented value in a while loop
        while(++x < 5) {
            x+=1;
        }

        // Then:
        assertNotEquals(6, x);
        assertEquals(5, x);
    }
}
