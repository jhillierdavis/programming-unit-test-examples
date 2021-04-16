package com.jhdit.java.learning.classes.interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example of disambiguation of default methods (with same signature) in multiple inheritance.
 */

interface Fly {
    default String move() {
        return fly();
    }

    default String fly() {
        return "fly";
    }
}

interface Swim {
    default String move() {
        return swim();
    }

    default String swim()  {
        return "swim";
    }
}

interface Adaptable extends Fly, Swim {
    @Override // Needs to disambiguate
    default String move() {
        return fly() + " or " + swim();
    }
}

class KingFisher implements Adaptable  {}

public class MultipleInheritanceAndDefaultMethodsExamples {

    @Test
    void explore()  {
        Adaptable adaptable = new KingFisher();

        assertEquals("fly", adaptable.fly());
        assertEquals("swim", adaptable.swim());
        assertEquals("fly or swim", adaptable.move());
    }
}
