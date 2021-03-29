package com.jhdit.java.learning.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShortestThenAlphaComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.compareTo(s2);
        }
        return Integer.compare(s1.length(), s2.length());
    }
}

class LongerHasPriorityComparator implements Comparator<String> {

    /**
     * Returns:
     *
     * -ive - if s1 < s2
     * 0 - if s1 == s2
     * +ive - if s1 > s2
     */

    public int compare(String s1, String s2) {
        return s2.length() - s1.length();
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
        Arrays.sort(strArrayToSort, new ShortestThenAlphaComparator());


        // Then: elements are sorted alphabetically
        assertEquals("One", strArrayToSort[0]);
        assertEquals("Five", strArrayToSort[2]);
        assertEquals("Three", strArrayToSort[strArrayToSort.length - 1]);
    }

    @Test
    public void sortWithLongerHasPriorityComparator() {
        // Given: a array of names (some of the same length)
        String[] names = {"Mary", "Jane", "Elizabeth", "Jo"};

        // When: array sort applied with custom comparator (prioritising by length)
        Arrays.sort(names, new LongerHasPriorityComparator());

        // Then: array is sorted as expected
        assertTrue(Arrays.equals(new String[] {"Elizabeth", "Mary", "Jane", "Jo"}, names));
    }

    @Test
    public void sort() {
        // Given: a array of names (some of the same length)
        String[] names = {"Mary", "Jane", "Elizabeth", "Jo"};

        // When: array sort applied with custom comparator (prioritising by length)
        Arrays.sort(names, new ShortestThenAlphaComparator());

        // Then: array is sorted as expected
        // assertEquals(new String[] {"Elizabeth",  "Jane", "Mary", "Jo"}, names);
        assertTrue(Arrays.equals(new String[] {"Jo",  "Jane", "Mary", "Elizabeth"}, names));
    }
}
