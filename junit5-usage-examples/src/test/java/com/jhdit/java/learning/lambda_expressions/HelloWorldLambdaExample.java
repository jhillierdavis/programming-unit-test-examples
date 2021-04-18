package com.jhdit.java.learning.lambda_expressions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
