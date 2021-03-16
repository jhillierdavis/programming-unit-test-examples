package com.jhdit.java.learning.operators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperatorPrecedenceTests {

    @Test
    public void multiplicativeBeforeAdditive() {
        // Multiplication (& division) have precedence over addition (& subtraction)
        assertSame(7, 1 + 2 * 3);
        assertSame(7, 1 + (2 * 3));
        assertSame(9, (1 + 2) * 3);

        // Left to right precedence for multiplication/division (equal precedence)
        assertSame(9, 9 / 3 * 3);
        assertSame(9, (9 / 3) * 3);
        assertSame(1, 9 / (3 * 3));

        // Longer example, left to right precedence, with multiplicative over additive
        assertSame(28, 8*8/2+2-3*2);
        assertSame(28, ((8*8)/2) + (2 - (3*2)));
        assertSame(30, (8*(8/2)) + ((2 - 3)*2));
        assertSame(-32, (8*8 / (2+2-3*2)));
    }
}
