package com.jhdit.java.learning.classes.interfaces;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Interfaces may be marked abstract (although implicitly so).
 *
 * Plus their methods may be declared public (although implicitly so)
 *
 * NB: So do not need to do either of these explicitly, although can, albeit with IDE warnings:
 *
 * * Modifier 'abstract' is redundant for interfaces
 * * Modifier 'public' is redundant for interface methods
 */

public abstract interface InterfacesMayBeExplicitlyDeclaredAbstract { // abstract implicitly (but can be declared explicitly)
    public boolean explicitlyPublicMethod(); // public implicitly  (but can be declared explicitly)

     default boolean defaultMethod() { // default methods MUST have an implementation
        return true;

    }
}

interface ParentInterface extends InterfacesMayBeExplicitlyDeclaredAbstract { // NB: not explicitly declared abstract or public
    boolean implicitlyPublicMethod(); // public by default

    // protected void protectedMethodNotAllowed();

    // private void privateMethodMustHaveABody();

    private void privateMethodWithBody()    {
        // allowed
    }
}

class ConcreteClass implements ParentInterface {
    public boolean implicitlyPublicMethod() { return true; } // Must be public (cannot have weaker access privilege)

    public boolean explicitlyPublicMethod() { return true; } // Must be public
}

class InterfacesMayBeDeclaredAbstractExamples {
    @Test
    void explore()  {
        // Given: an instance of a concrete implementation
        ConcreteClass c = new ConcreteClass();

        // Then: methods invocation (including default) as expected
        assertTrue(c.explicitlyPublicMethod());
        assertTrue(c.implicitlyPublicMethod());
        assertTrue(c.defaultMethod());
    }

}

