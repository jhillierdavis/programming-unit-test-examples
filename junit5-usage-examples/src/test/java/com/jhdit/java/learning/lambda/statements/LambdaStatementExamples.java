package com.jhdit.java.learning.lambda.statements;

import org.junit.jupiter.api.Test;

import java.util.function.*;

public class LambdaStatementExamples {

    @Test
    void valid()    {
        DoubleFunction<Double> areaOfCircle = r -> Math.PI * r * r;

        BiFunction<Integer, Integer, Integer> divide = (x, y) -> x/y;

        IntPredicate test = x -> x == 10;

        Supplier<String> hello = () -> "Hello"; // Supplies a result

        BiPredicate<Integer, Integer> integerTest = (x,y) -> x == y;
    }

    @Test
    void invalid()    {
        /*

        DoublePredicate<Integer, Integer> invalid = (x, y) -> x == y; // Operator '==' cannot be applied to 'Double'

        DoubleConsumer cube = x -> x * x * x; // Bad return type in lambda expression: double cannot be converted to void

        BiPredicate<Integer, Integer> add = (x, y) -> x + y; // Bad return type in lambda expression: int cannot be converted to boolean

        Function<String> hello = () -> "Hello"; // Wrong number of type arguments: 1; required: 2

        */
    }
}
