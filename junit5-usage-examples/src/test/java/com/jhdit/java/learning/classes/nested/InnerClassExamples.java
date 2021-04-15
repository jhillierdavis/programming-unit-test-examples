package com.jhdit.java.learning.classes.nested;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class External {
    private final int x = 3;

    class Internal {
        private final int y = External.this.x;

        int getY()  { return y; }
    }
}

public class InnerClassExamples {

    @Test
    void explore()  {
        // Setup: instantiate an inner class
        External external = new External();
        External.Internal internal = external.new Internal();

        // Expect
        assertEquals(3, internal.getY() );
    }
}
