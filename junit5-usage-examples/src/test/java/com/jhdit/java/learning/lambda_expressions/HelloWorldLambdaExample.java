package com.jhdit.java.learning.lambda_expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A lambda expression can implement interfaces with a single unimplemented (i.e. abstract) method.
 * These types of interfaces are called Functional Interfaces (the annotation enforces adherence to this rule)
 * (Default & static method in interfaces ARE implemented i.e. are NOT abstract, so these are fine on a functional interface)
 */

@FunctionalInterface
interface MyFunction  {
    String action(String text1, String text2);
}

class HelloWorldLambdaExamples {

    @Test
    void explore()  {

        MyFunction lambda = (s1, s2) -> s1 + " + " + s2 + "!";
        // Alt:
        // MyFunction lambda = (s1, s2) -> { return s1 + " + " + s2 + "!"; };

        assertEquals("Hello + World!", lambda.action("Hello", "World"));
    }

    @Test
    void exploreWithVariableCapture()  {
        var effectivelyFinalVariable = "Lambda";

        MyFunction lambda = (s1, s2) -> effectivelyFinalVariable + " : " + s1 + " + " + s2 + "!";

        // effectivelyFinalVariable = "Change!"; // No longer effectively final!

        assertEquals("Lambda : Hello + World!", lambda.action("Hello", "World"));
    }
}
