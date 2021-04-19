package com.jhdit.java.learning.lambda_expressions;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class LambdaGotchaExamples {

    void exploreLambdasUsingVarInConsumer()  {
        // Valid
        Consumer<String> con1 = x -> System.out.println(x);
        Consumer<String> con2 = (final var x) -> System.out.println(x);

        // Invalid (will NOT compile)
        /*
        Consumer<String> con3 = final x -> System.out.println(x);
        Consumer<String> con4 = final var x -> System.out.println(x);
        */
    }

    void exploreLambdasUsingVarInBiConsumer()   {
        BiConsumer<String, String> bi1 = (x, y) -> System.out.println(x + y);
        BiConsumer<String, String> bi2 = (x, y) -> { System.out.println(x + y); }; // No return, since void
        BiConsumer<String, String> bi3 = (var x, var y) -> System.out.println(x + y);
        BiConsumer<String, String> bi4 = (final var x, final var y) -> System.out.println(x + y);
        BiConsumer<String, String> bi5 = (final var x, var y) -> System.out.println(x + y);
        BiConsumer<String, String> bi6 = (var x, final var y) -> System.out.println(x + y);
        BiConsumer<String, String> bi7 = (final String x, final String y) -> System.out.println(x + y);
        BiConsumer<String, String> bi8 = (String x, final String y) -> System.out.println(x + y);

        // Invalid (cannot mix var & type) - compiler error
        /*
        BiConsumer<String, String> invalid1 = (var x, final String y) -> System.out.println(x + y);
         */
    }
}
