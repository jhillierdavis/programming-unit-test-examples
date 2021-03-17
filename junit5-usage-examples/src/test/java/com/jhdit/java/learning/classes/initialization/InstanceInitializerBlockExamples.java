package com.jhdit.java.learning.classes.initialization;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InstanceInitializerBlockExamples {

    class Example {
        int instanceVariable; // Uninitialized

        // Initialization block
        {
            instanceVariable = 17;
        }
    }

    @Test
    public void explore()   {
        // Given:
        Example example = new Example();

        // Then: instance variable is initialized
        assertTrue( example.instanceVariable == 17);
    }
}
