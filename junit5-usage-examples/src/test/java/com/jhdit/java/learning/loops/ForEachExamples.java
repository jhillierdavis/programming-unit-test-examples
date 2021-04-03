package com.jhdit.java.learning.loops;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * For 'for each' basic examples
 */

public class ForEachExamples {

    @Test
    public void forEachExample() {
        // Setup:
        List<String> list = new ArrayList<String>();
        list.add("Apple"); // 5 chars
        list.add("Banana"); // 6 chars
        list.add("Orange"); // 6 chars
        int numberOfChars = 0;

        // When: iterate of list using 'foreach' & sum # of chars
        for(String name: list)  {
            numberOfChars += name.length();
        }

        // Then: total numbers of aggregated chars is as expected
        assertEquals(17, numberOfChars);
    }
}
