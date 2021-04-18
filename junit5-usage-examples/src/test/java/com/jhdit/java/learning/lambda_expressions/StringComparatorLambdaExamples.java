package com.jhdit.java.learning.lambda_expressions;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Basic example introducing Java Lambda functions using String Comparator
 * (via the Comparator interface - a functional interface)
 */

public class StringComparatorLambdaExamples {

    @Test
    void withoutLambdaUsingAnonymousClass() {
        // Given: a (non-lambda) comparator (using an anonymous class, implementing comparator interface)
        Comparator<String> strComparator = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2); // use 'natural' ordering (alphabetic)
            }
        };

        // Then: comparison is positive
        check(strComparator);
    }

    @Test
    void withLambda() {
        // Given: a lambda comparator (NB: Comparator is a functional interface - one abstract method only)
        Comparator<String> strComparatorAsLambda = (s1, s2) -> s1.compareTo(s2);

        // Then: comparison as expected (lexicographical ordering)
        check(strComparatorAsLambda);
    }

    @Test
    void withLambdaVerboseFormat() {
        // Given: a lambda comparator (NB: Comparator is a functional interface - one abstract method only)
        Comparator<String> strComparatorAsLambda = (String s1, String s2) -> { return s1.compareTo(s2); };

        // Then: comparison as expected (lexicographical ordering)
        check(strComparatorAsLambda);
    }

    @Test
    void withLambdaUsingMethodReference() {
        // Given: a lambda comparator (NB: Comparator is a functional interface - one abstract method only)
        Comparator<String> strComparatorAsLambda = String::compareTo;

        // Then: comparison as expected (lexicographical ordering)
        check(strComparatorAsLambda);
    }

    @Test
    void withInlineLambda() {
        check((s1, s2) -> s1.compareTo(s2));
    }

    @Test
    void withInlineLambdaVerboseFormat() {
        check((String s1, String s2) -> { return s1.compareTo(s2); });
    }

    @Test
    void withInlineLambdaUsingMethodReference() {
        check(String::compareTo);
    }

    private void check(Comparator<String> strComparator)    {
        assertEquals(0, strComparator.compare("same", "same"));
        assertTrue(strComparator.compare("sensitive", "CASE") > 0);
        assertTrue(strComparator.compare("1", "A") < 0);
        assertTrue(strComparator.compare("A", "a") < 0);
        assertTrue(strComparator.compare("A", "B") < 0);
    }
}
