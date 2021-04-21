package com.jhdit.java.learning.classes.interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface InterfaceOne {
    int field = 99; // static

    default int method()   {
        return field; // Equivalent to  'return InterfaceOne.field' or 'return this.field' (even though static)
    }
}

interface InterfaceTwo {
    int field = 1983; // static

    private int method()    {
        return field;
    }
}

class Concrete implements InterfaceOne, InterfaceTwo { }

public class InterfacePrivateMethodAndStaticFieldExamples {

    @Test
    void explore()  {
        Concrete concrete = new Concrete();

        assertEquals(99, concrete.method());
    }
}
