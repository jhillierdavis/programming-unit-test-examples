package com.jhdit.java.learning.primitives.wrappers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Explore basics of Float object (wrapper for float primitive type)
 */

public class FloatWrapperExamples {

    @Test
    public void initialisationFromString() {
        // Setup: primitive value
        String str = "12.25";

        // Given: initialise from String
        Float floatObject = Float.valueOf(str);

        // Then: check equivalence
        assertEquals(12.25F, floatObject);
        assertEquals(12.25F, floatObject.floatValue());
    }

    @Test
    public void initialisationFromPrimitive() {
        // Setup: primitive value
        float primitive = 98.765F;

        // Given: initialise from float (primitive)
        Float floatObject = Float.valueOf(primitive);

        // Then: confirm equivalence
        assertEquals(primitive, floatObject);
        assertEquals(primitive, floatObject.floatValue());
    }
}
