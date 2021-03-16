package com.jhdit.java.learning.operators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Operator precedence & associativity rules
 *
 * (Precedence = priority, Associativity = order for same precedence)
 *
 * Parenthesis (brackets) can be used to override precedence & associativity
 *
 * Initial examples:
 *
 * 2 + 3 * 4 is interpreted as 2 + (3 * 4) , resulting in 14
 * 1 + 2 - 3 is interpreted as ((1 + 2) - 3) since plus & minus have same precedence & left associativity
 * - - 4 is interpreted as (- (-4) ) since the unary operator has right associativity
 *
 */

public class OperatorPrecedenceExamples {

    @Test
    public void multiplicativeBeforeAdditive() {
        // Multiplication has precedence over addition
        assertEquals(14, 2 + 3 * 4);
        assertEquals(14, 2 + (3 * 4)); // Above is equivalent to this (using parenthesis)
        assertEquals(20, (2 + 3) * 4);

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
