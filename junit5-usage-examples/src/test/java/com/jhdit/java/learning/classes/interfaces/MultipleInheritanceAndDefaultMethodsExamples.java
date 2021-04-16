package com.jhdit.java.learning.classes.interfaces;

interface Fly {
    default void move() {
        System.out.println("Take to the skies!");
    }
}

interface Swim {
    default void move() {
        System.out.println("Take to the water!");
    }
}

interface Adaptable extends Fly, Swim {
    @Override // Needs to disambiguate
    default void move() {
        System.out.println("Take to the sky or the water!");
    }
}


public class MultipleInheritanceAndDefaultMethodsExamples {
}
