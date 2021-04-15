package com.jhdit.java.learning.classes.nested;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Inner classes cannot contains static variables or methods, unless they are also static.
 */

class Outer {
    private int x = 5;

    protected class InnerProblematic   {
        // Static declarations are NOT supported (unless inner class is Static!)

        /*
        public static int x = 10;

        public static int getX() {
            return x;
        }
        */
    }

    protected static class InnerOk {

        public static int x = 10;

        public static int getX() {
            return x;
        }
    }
}

public class InnerClassStaticRestrictionsExamples {
    @Test
    void exploreInnerClassUsage()   {
        // Setup:
        Outer outer = new Outer();

        // When: instantiated
        Outer.InnerProblematic innerProblematic = outer.new InnerProblematic();
        Outer.InnerOk innerOk = new Outer.InnerOk();

        // Expect:
        assertTrue(innerProblematic instanceof Outer.InnerProblematic);
        assertTrue(innerOk instanceof Outer.InnerOk);
        assertEquals(10, innerOk.getX());
    }
}
