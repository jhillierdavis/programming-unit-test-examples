package com.jhdit.java.learning.loops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Some basic examples of 'for' loops in Java
 */

public class ForLoopExamples {

    @Test
    public void badPractice()   {
        // Setup:
        int[] values = {0,1,2,3,4,5,6,7,8,9};

        // When: (bad practice in reality) use for loop construct to sum
        int sum = 0;
        for (int i =0; i < values.length; sum+=i++ ); // NB: No for loop body

        // Then: sum (NB: of index, not values) is expected  (10 factorial)
        assertEquals(45, sum);
    }

    @Test
    public void matrixArrayExample()    {
        // Setup: a matrix array
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        /*
         * 3x3 matrix (rows & columns) of values:
         *
         * 1|2|3
         * 4|5|6
         * 7|8|9
         */

        // When: gather the diagonal values /
        int[] values = new int[3];
        for (int row = 0, column = 2; !(row == 3 || column == -1); row++, column--)    {
            values[row] = matrix[row][column];
        }

        // Then: values are as expected
        assertEquals(3, values[0]);
        assertEquals(5, values[1]);
        assertEquals(7, values[2]);
    }
}
