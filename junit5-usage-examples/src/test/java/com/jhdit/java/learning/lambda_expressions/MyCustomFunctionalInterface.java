package com.jhdit.java.learning.lambda_expressions;

@FunctionalInterface
public interface MyCustomFunctionalInterface {

    void singleAbstractMethod();

    @Override
    boolean equals(Object obj); // Does not count as additional abstract method (as part of Object)

    default void defaultMethod() {} // Does not count as additional abstract method

    static void staticMethod() {} // Does not count as additional abstract method
}