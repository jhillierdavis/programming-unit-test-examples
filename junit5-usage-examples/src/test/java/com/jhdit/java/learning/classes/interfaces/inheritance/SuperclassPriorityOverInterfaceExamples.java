package com.jhdit.java.learning.classes.interfaces.inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/***
 * Inheritance rule for default methods:
 *
 * A superclass method takes priority over an interface default method.
 *
 * NB: Superclass method must be public! (to match interface default method) or compliation error (due ot weaker access privileges)
 */

interface GreyPrimer { // implicitly public abstract
    final String color = "grey"; // Implicitly public static final!

    default String getColor()  { // implicitly public abstract
        return this.color; // this used, but field is static!
    }
}

class BluePaint {
    private String color = "Blue";

    public String getColor() {
        return this.color;
    }
}

class Painted extends BluePaint implements GreyPrimer {
    // NB: 'Blue.getColor()' must be public, else compiler error: 'getColor()' in 'BluePaint' clashes with 'getColor()' in 'GreyPrimer'; attempting to assign weaker access privileges ('package-private'); was 'public'
}

public class SuperclassPriorityOverInterfaceExamples {
        @Test
        void explore()  {
            assertEquals("Blue", (new Painted()).getColor());
        }
}
