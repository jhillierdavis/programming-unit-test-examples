package com.jhdit.java.learning.classes.access;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Explore access to private member data within the same class
 */

class Encapsulated {
    private final int value;

    Encapsulated(int value) {
        this.value = value;
    }

    int peek(Encapsulated e)    {
        // Can see private member data (since of the same class)
        return e.value;
    }
}

class ExtendedEncapsulated extends Encapsulated {
    ExtendedEncapsulated(int value) {
        super(value);
    }

    // Cannot do this (compiler error as not visible)
    /*
    int subclassPeek(Encapsulated e) {
        return e.value;
    }
    */
}

class PrivateMemberVisibilityExamples {

    @Test
    void explore()  {
        Encapsulated x = new Encapsulated(123);
        Encapsulated y = new Encapsulated(456);
        ExtendedEncapsulated z = new ExtendedEncapsulated(789);

        // Then: private data can be accessed within the same class (or superclass)
        assertEquals(456, x.peek(y));
        assertEquals(789, x.peek(z));
    }
}
