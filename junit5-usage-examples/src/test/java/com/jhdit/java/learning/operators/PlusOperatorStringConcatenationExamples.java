package com.jhdit.java.learning.operators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Plus operator is overloaded:
 *
 * If either operand is a String, the + operator becomes a String concatenation.
 * If both operands are numbers, the + operator becomes the addition operator.
 */


public class PlusOperatorStringConcatenationExamples {

    @Test
    public void concatenateNumbers()    {
        // Given: an integer
        int num = 2;

        // Then: plus operator can add
        assertEquals(5, num + 3);

        // And: plus operator can concatenate
        assertEquals("23", "" + num + 3);
        assertEquals("23", num + "" + 3);
        assertEquals("23", num + "3");

        // And: both!  Numbers are added (due to left-to-right precedence), but result is a String.
        assertEquals("5", num + 3 + "");
    }

    @Test
    public void compoundAdditiveOperatorStringConcatonation()   {
        // Given: an initial string
        String s = "1234";

        // When: compound additive operator applied to a string
        s += "567";
        s += "890";

        // Then: resulting string is the concatenated set
        assertEquals("1234567890", s);
    }
}
