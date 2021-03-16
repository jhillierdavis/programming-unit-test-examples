package com.jhdit.java.learning.primitives.wrappers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerWrapperExamples {

    @Test
    public void intWrapperCreationAndConversion()    {
        // Setup: a primitive integer (not an object!)
        int ultimateAnswer = 42;

        // NB: do not use constructor for wrapper
        // Integer wrapper = new Integer(ultimateAnswer); // deprecated!

        // When: a wrapper (object) is created
        Integer wrapper = Integer.valueOf(ultimateAnswer);
        assertEquals(ultimateAnswer, wrapper);

        // And: can be converted back to primitive
        int original = wrapper.intValue();
        assertEquals(ultimateAnswer, original);

        // And: can be converted to another object e.g. String
        String str = String.valueOf(wrapper);
        assertEquals("" + ultimateAnswer, str);
    }

    @Test
    public void intWrapperConstantsSuchAsMaxAndMin()    {
        // Check: Integer max. & min. values
        assertEquals(2147483647, Integer.MAX_VALUE);
        assertEquals(-2147483648, Integer.MIN_VALUE);
        assertEquals(4, Integer.BYTES);
    }

    @Test
    public void intWrapperMethods()    {
        // Explore: Integer methods
        assertEquals(36, Integer.sum(17, 19));

        // Explore: number bases
        assertEquals("141", Integer.toOctalString(97));
        assertEquals("61", Integer.toHexString(97));
        assertEquals("1100001", Integer.toBinaryString(97));
    }


}
