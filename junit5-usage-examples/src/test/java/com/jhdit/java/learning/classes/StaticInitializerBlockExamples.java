package com.jhdit.java.learning.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Example {
    public static int sharedVariable; // Uninitialized

    static {
        // Initialization (once only) on first use
        sharedVariable = 99;

        // Typically used where dynamic/complex to perform (unlike this simple example) e.g. read config. setting
    }
}

public class StaticInitializerBlockExamples {

    @Test
    public void explore()   {
        assertTrue(99 == Example.sharedVariable);
    }
}
