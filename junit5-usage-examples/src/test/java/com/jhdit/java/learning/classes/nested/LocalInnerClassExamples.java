package com.jhdit.java.learning.classes.nested;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Explore creation of classes embedded within another class (test in this case) method
 *
 * NB: an unusual/rare case
 */

class LocalInnerClassExamples {

    @Test
    void explore()   {
        // Setup: a local variable
        int value = 99;

        // Given: class declaration within a method
        class MethodClass {
            // Implementation

            int getValue() {
                return value; // NB: can use outer variable IF effectively final!
            }
        }

        // value += 100; // NB: Cannot amend or will not be final (or effectitly final!)

        // When: an instance is created
        MethodClass methodClass = new MethodClass();

        // Then: class behaviour can be invoked on instance (with the scope of this method)
        assertTrue(methodClass instanceof MethodClass);
        assertEquals(value, methodClass.getValue());
    }
}
