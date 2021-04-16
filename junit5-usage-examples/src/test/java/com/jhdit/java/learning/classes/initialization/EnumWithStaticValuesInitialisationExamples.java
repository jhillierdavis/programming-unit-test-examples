package com.jhdit.java.learning.classes.initialization;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

enum MyEnumWithStaticValues {
    A, B;

    final static int staticValue = 100;
    static int anotherStaticValue;

    static {
        // NB: not possible if used in constructor
        anotherStaticValue = 100;
    }

    // NB: Constructor is implicitly private (so explicit declaration as private redundant)
    private MyEnumWithStaticValues() {
        // Compiler error unless staticValue final (since used in constructor)
        System.out.println("staticValue is " + staticValue);
    }
}

public class EnumWithStaticValuesInitialisationExamples {
    @Test
    void explore()  {
        assertEquals(100, MyEnumWithStaticValues.staticValue);
        assertEquals(100, MyEnumWithStaticValues.anotherStaticValue);
    }
}
