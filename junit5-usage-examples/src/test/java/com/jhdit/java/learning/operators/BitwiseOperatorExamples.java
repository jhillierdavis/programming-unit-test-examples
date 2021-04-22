package com.jhdit.java.learning.operators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BitwiseOperatorExamples {

    @Test
    void explore()  {
        boolean carrot = true;
        boolean potato = false;
        var broccoli = false;

        carrot = carrot & potato;
        assertEquals(false, carrot);

        broccoli = broccoli ? !carrot : potato;
        assertEquals(false, broccoli);

        potato = !broccoli ^ carrot; // bitwise exclusive OR (returns true if and only if the operands are different)
        assertEquals(true, potato);
    }

    @Test
    void xor()    {
        // XOR (eXclusive OR) is true only if operands differ

        assertTrue(false ^ true);
        assertTrue(true ^ false);
        assertFalse(true ^ true);
        assertFalse(false ^ false);
    }

    @Test
    void or()    {
        // inclusive OR is true if either of the operands as true

        assertTrue(false | true);
        assertTrue(true | false);
        assertTrue(true | true);
        assertFalse(false | false);
    }
}
