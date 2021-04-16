package com.jhdit.java.learning.classes.initialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Example of circumventing the standard initialisation order (normally static -> instance -> constructor).
 *
 * NB: Similar to an enumerations.
 */

class SelfRef {
    public static final SelfRef self = new SelfRef();
    static int value = 1;

    static {
        System.out.println("Static init - begin (value = " + value + ")");
        value += 5;
        System.out.println("Static init - end (value = " + value + ")");
    }

    {
        System.out.println("Instance init - begin (value = " + value + ")");
        value *= 10;
        System.out.println("Instance init - end (value = " + value + ")");
    }

    SelfRef()   {
        System.out.println("Constructor init - begin (value = " + value + ")");
        value -= 3;
        System.out.println("Constructor init - end (value = " + value + ")");
    }
}

public class SelfReferentialInitialisationExamples {
    @Test
    void explore() {
        assertNotNull(SelfRef.self);
        assertEquals(6, SelfRef.value); // value is initially 0, then re-set to 1 before static initializer block executes
    }
}
