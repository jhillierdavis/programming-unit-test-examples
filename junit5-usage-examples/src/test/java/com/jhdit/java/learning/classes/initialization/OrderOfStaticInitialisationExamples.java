package com.jhdit.java.learning.classes.initialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StaticXandY {
    // Static initialisation will occur in order
    static int x = 99;
    static { x ++; }
    static int y = x;
}

class StaticAandB {
    // Static initialisation will occur in order
    static int a = 99;
    static int b = a;
    static { b ++; }
}

public class OrderOfStaticInitialisationExamples {
    @Test
    void explore()  {
        assertEquals(100, StaticXandY.x);
        assertEquals(100, StaticXandY.y);

        // And:
        assertEquals(99, StaticAandB.a);
        assertEquals(100, StaticAandB.b);
    }

}
