package com.jhdit.java.learning.classes.interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Examples of verbose and implicit interface declaration.
 */

abstract interface Verbose // abstract is redundant for interfaces (but allowed by compiler)
{
    int staticMemberVariable = 10; // member variables are implicitly static!

    abstract void doSomething(); // abstract is redundant for interface methods (but allowed by compiler)

    static int staticMethod() { return staticMemberVariable; }

    default int defaultMethod() {
        return staticMemberVariable;
    }
}

class VerboseImplementation implements Verbose {
    public void doSomething() {} // Must be public
}


public class VerboseInterfaceExamples {

    @Test
    void exploreInterfaceStaticValuesAndMethods() {
        assertEquals(Verbose.staticMemberVariable, Verbose.staticMethod());
    }

    @Test
    void exploreInterfaceDefaultMethods() {
        // Given: an implementation of an interface
        Verbose v = new VerboseImplementation();

        // Then: default method can be invoked
        assertEquals(Verbose.staticMemberVariable, v.defaultMethod());
        assertEquals(v.staticMemberVariable, v.defaultMethod());
    }
}
