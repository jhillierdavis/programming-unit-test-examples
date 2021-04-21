package com.jhdit.java.learning.classes.methods.overriding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Parent  {
    public double foo(double value) {
        return 2 * value;
    }
}

class Child extends Parent {
    @Override
    public double foo(double value)   {
        return 5 * value;
    }
}

public class OverridingExamples {

    @Test
    void explore()  {
        Parent parent = new Parent();
        assertEquals(4, parent.foo(2));

        parent = new Child();
        assertEquals(10, parent.foo(2)); // Polymorphism - the 'lowest' implementation will be used (i.e. Child)

        Child child = new Child();
        assertEquals(10, parent.foo(2));

        // child = parent; // Incompatible types!
    }
}
