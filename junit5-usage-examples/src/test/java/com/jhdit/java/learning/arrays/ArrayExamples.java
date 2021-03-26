package com.jhdit.java.learning.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Explore Java array behaviour
 */

public class ArrayExamples {

    private int arraySum(int[] arrayValues) {
        int sum = 0;
        for (int arrayValue : arrayValues) {
            sum += arrayValue;
        }
        return sum;
    }

    @Test
    public void arrayOfPrimitiveValuesDeclarationAndInitialisation()  {
        // Setup: array declaration & basic initialisation
        int[] firstPrimes = new int[4];
        firstPrimes[0] = 2;
        firstPrimes[1] = 3;
        firstPrimes[2] = 5;
        firstPrimes[3] = 7;

        // Setup: alternative array declaration (brackets after type, C-Style) & simpler initialisation
        int morePrimes[] = { 11, 13, 17, 19 };

        // Then: expect
        assertEquals(arraySum(firstPrimes), 17);
        assertEquals(arraySum(morePrimes), 60);
    }

    @Test
    public void arrayOfStringValuesDeclarationAndInitialisation()    {
        // Setup:
        String[] strArray = {"Alpha", "Beta", "Gamma"};

        // Then:
        assertEquals(3, strArray.length);
        assertEquals("Gamma", strArray[strArray.length -1]);
    }

    @Test
    public void arraySort() {
        // Setup: declaration
        String[] strArrayToSort;

        // Setup: initialize - NB: needs new String[] since not initialized at declaration
        strArrayToSort = new String[] {"One", "Two", "Three", "Four", "Five"};

        Arrays.sort(strArrayToSort);
        assertEquals("Five", strArrayToSort[0]);
        assertEquals("Two", strArrayToSort[strArrayToSort.length - 1]);
    }
}
