package com.jhdit.java.learning.primitives.wrappers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BooleanWrapperExamples {

    @Test
    public void checkPrimitiveEquivalence() {
        assertEquals(true, Boolean.TRUE);
        assertEquals(false, Boolean.FALSE);
    }
}
