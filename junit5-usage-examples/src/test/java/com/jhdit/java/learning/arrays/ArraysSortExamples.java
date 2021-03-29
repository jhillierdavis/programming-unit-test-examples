package com.jhdit.java.learning.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.compareTo(s2);
        }
        return Integer.compare(s1.length(), s2.length());
    }
}

public class ArraysSortExamples {
    @Test
    public void arraySortUsingDefault() {
        // Setup: declaration
        String[] strArrayToSort;

        // Setup: initialize - NB: needs new String[] since not initialized at declaration
        strArrayToSort = new String[] {"One", "Two", "Three", "Four", "Five"};

        // When: sort is performed (using default implicit comparator)
        Arrays.sort(strArrayToSort);

        // Then: elements are sorted alphabetically
        assertEquals("Five", strArrayToSort[0]);
        assertEquals("One", strArrayToSort[2]);
        assertEquals("Two", strArrayToSort[strArrayToSort.length - 1]);
    }

    @Test
    public void arraySortUsingCustomComparator() {
        // Setup: declaration
        String[] strArrayToSort;

        // Setup: initialize - NB: needs new String[] since not initialized at declaration
        strArrayToSort = new String[] {"One", "Two", "Three", "Four", "Five"};

        // When: sort is performed (using default implicit comparator)
        Arrays.sort(strArrayToSort, new LengthComparator());


        // Then: elements are sorted alphabetically
        assertEquals("One", strArrayToSort[0]);
        assertEquals("Five", strArrayToSort[2]);
        assertEquals("Three", strArrayToSort[strArrayToSort.length - 1]);
    }
}
