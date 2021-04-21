package com.jhdit.java.learning.lambda.statements;

import org.junit.jupiter.api.Test;

import java.util.function.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaStatementExamples {

    @Test
    void valid()    {
        DoubleFunction<Double> areaOfCircle = r -> Math.PI * r * r;

        BiFunction<Integer, Integer, Integer> divide = (x, y) -> x/y;

        IntPredicate test = x -> x == 10;

        Supplier<String> hello = () -> "Hello"; // Supplies a result

        BiPredicate<Integer, Integer> integerTest = (x,y) -> x == y;

        Consumer<String> conSingle = x -> System.out.println(x);
        Consumer<String> conSingleWithBrackets = (x) -> System.out.println(x);
        Consumer<String> conSingleWithParen = (x) -> { System.out.println(x); };
        Consumer<String> conSingleWithType = (String x) -> System.out.println(x);
        Consumer<String> conSingleWithTypeAndFinal = (final String x) -> System.out.println(x);
        Consumer<String> conSingleWithTypeAndFinalAndBrackets = (final String x) -> { System.out.println(x); };
        Consumer<String> conSingleWithVar = (var x) -> System.out.println(x);
        Consumer<String> conSingleWithVarAndFinal = (final var x) -> System.out.println(x);

        BiConsumer<String, String> biCon = (final var x, var y) -> System.out.println(x+y);

        Consumer<Integer> lambda = (x) -> {
            x++;
            System.out.println(x);
        };

        Integer integer = Integer.valueOf(0);
        assertEquals(1, ++integer); // Can increment wrapper classes


    }

    @Test
    void invalid()    {
        /*

        DoublePredicate<Integer, Integer> invalid = (x, y) -> x == y; // Operator '==' cannot be applied to 'Double'

        DoubleConsumer cube = x -> x * x * x; // Bad return type in lambda expression: double cannot be converted to void

        BiPredicate<Integer, Integer> add = (x, y) -> x + y; // Bad return type in lambda expression: int cannot be converted to boolean

        Function<String> hello = () -> "Hello"; // Wrong number of type arguments: 1; required: 2

        String city = "Munich";
        BiFunction<Integer, Integer, String> lambaSubstring = String::substring; // Non-static method cannot be referenced from a static context

        Consumer<String> con1 = final String x -> System.out.println(x); // Invalid syntax (requires parenthesis)

        Function<Double, Double> lambdaCircumference = r -> { double circumference = 2 * Math.PI * r; }; // Missing return statement

        */


    }
}
