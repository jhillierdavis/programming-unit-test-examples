package com.jhdit.java.learning.classes.interfaces.inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * If there is a conflict (for interface default method inheritance) treat as abstract
 * (i.e. must be implemented afresh - although can call 'super' to choose an existing implementation)
 */

interface A {
    public default String foo() {
        return "A";
    }
}

interface B {
    default String foo() { // implicitly public
        return "B";
    }
}

class C implements A, B {
    public String foo()    {
        return B.super.foo();
    }
}

public class InterfaceDefaultMethodMultipleInheritanceClashExamples {

    @Test
    public void explore()    {
        assertEquals("B", (new C()).foo());
    }
}
