package com.jhdit.java.learning.classes.default_values;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DefaultValues {
    private boolean aBoolean; // initialised to false
    private byte aByte; // initialised to zero
    private short aShort; // initialised to zero
    private int anInt; // initialised to zero
    private long aLong; // initialised to zero
    private float aFloat; // initialised to zero
    private double aDouble; // initialised to zero
    private char ch; // initialised to '\u0000'
    private Object ref;
    private String refToString;

    @Test
    void exploreDefaults()  {
        assertEquals(false, this.aBoolean);
        assertEquals(0, this.aByte);
        assertEquals(0, this.aShort);
        assertEquals(0, this.anInt);
        assertEquals(0, this.aLong);
        assertEquals(0, this.aFloat);
        assertEquals(0, this.aDouble);
        assertEquals('\u0000', this.ch);
        assertNull(this.ref);
        assertNull(this.refToString);
    }

    @Test
    void exploreWrappers()  {
        Integer integer = Integer.valueOf(0);

        assertEquals(0, integer);
    }

}
