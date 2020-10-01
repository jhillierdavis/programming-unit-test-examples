package com.jhdit.junit5.examples.disabled;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Examples of ignored tests
 */

class DisabledExamples {

    /**
     * Test exclusion example
     */
    @Disabled(value = "TODO")
    @Test
    void ignoreForNow() {
        assertEquals(true, false);
    }
}
