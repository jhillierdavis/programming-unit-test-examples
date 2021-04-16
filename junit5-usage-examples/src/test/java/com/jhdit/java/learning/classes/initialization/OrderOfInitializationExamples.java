package com.jhdit.java.learning.classes.initialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Explore order of class & object initialisation:
 *
 * 1) static variables & static initializer blocks (in order declared in class)
 * 2) instance variables & instance initializers blocks  (in order declared in class)
 * 3) constructor(s)
 */

class Sequence {
    static int x = 1;
    static final int y;

    {
        x *= 10;
        System.out.println("Sequence: Third (initialisation block: x = " + x + ")");
    }


    static {
        // Static blocks initialised first
        x += 3;
        System.out.println("Sequence: First (static initialisation block: x = " + x + ")");

    }

    {
        x *= 2;
        System.out.println("Sequence: Fourth (initialisation block: x = " + x + ")");
    }

    static {
         // Static blocks initialised first
        x += 7;
        System.out.println("Sequence: Second  (static initialisation block: x = " + x + ")");
        y = x;
    }

    Sequence()  {
        x -= 3;
        System.out.println("Sequence: Fifth  (constructor: x = " + x + ")");
    }

}

class OrderOfInitialisationExamples  {

    @Test
    void exploreStaticOnly()  {
        assertEquals(11, Sequence.y);
    }

    @Test
    void explore()  {
        // When: object initialised
        Sequence s = new Sequence();

        // Then: sequence of initialisation is as expected
        assertEquals(217, s.x);
    }
}