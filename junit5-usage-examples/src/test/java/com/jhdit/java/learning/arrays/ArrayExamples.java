package com.jhdit.java.learning.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Explore Java array behaviour
 */

public class ArrayExamples {

    private int arraySum(int[] arrayValues) {
        int sum = 0;
        for (int i=0; i < arrayValues.length; i++)  {
            sum += arrayValues[i];
        }
        return sum;
    }

    @Test
    public void arrayDeclaration()  {
        // Setup: array declaration & basic initialisation
        int[] firstPrimes = new int[4];
        firstPrimes[0] = 2;
        firstPrimes[1] = 3;
        firstPrimes[2] = 5;
        firstPrimes[3] = 7;

        // Setup: alternative array declaration (brackets after type) & simpler initialisation
        int morePrimes[] = { 11, 13, 17, 19 };

        // Then: expect
        assertTrue(17 == arraySum(firstPrimes));
        assertTrue(60 == arraySum(morePrimes));
    }
}
