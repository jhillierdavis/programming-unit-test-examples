package com.jhdit.java.learning.classes.interfaces;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Interfaces may be marked:
 *
 * * public
 * * abstract
 *
 * NB: However, implicitly so, so do not need to do so explicitly
 */

public abstract interface InterfacesMayBeDeclaredPublicAndOrAbstract { // abstract implicitly (but can be declared explicitly)
    public boolean foo(); // public implicitly  (but can be declared explicitly)

     default boolean defaultMethod() { // default methods MUST have an implementation
        return true;

    }
}

interface ParentInterface extends InterfacesMayBeDeclaredPublicAndOrAbstract { // NB: not explicitly declared abstract or public
    boolean bar(); // public by default
}

class ConcreteClass implements ParentInterface {
    public boolean bar() { return true; } // Must be public (cannot have weaker access privilege)

    public boolean foo() { return true; } // Must be public
}

class InterfacesMayBeDeclaredPublicAndOrAbstractExamples {
    @Test
    void explore()  {
        // Given: an instance of a concrete implementation
        ConcreteClass c = new ConcreteClass();

        // Then: methods invocation (including default) as expected
        assertTrue(c.foo());
        assertTrue(c.bar());
        assertTrue(c.defaultMethod());
    }

}

