package com.jhdit.java.learning.lambda_expressions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Examples of using Java Lambda Method References (e.g. String::compareToIgnoreCase )
 */

class TextFilter {
    static boolean isAlpha(String str)    {
        return str.equalsIgnoreCase("alpha");
    }

    int sortText(String s1, String s2)  {
        return s1.compareTo(s2);
    }
}

public class LambdaMethodReferenceExamples {

    @Test
    void exploreUsingMethodReferenceOfRemoveAlpha() {
        // Given: a populated collection of type String
        List<String> names = populateTestStringCollection();

        // Then: collection sequential order is per addition order
        assertEquals(4, names.size());
        assertEquals("Alpha", names.get(3));
        assertTrue(names.contains("alpha"));

        // When: sorted via a method reference
        names.removeIf(TextFilter::isAlpha);
        // names.removeIf(s -> TextFilter.isAlpha(s)); // Equivalent using Lambda expression

        // Then: collection sequential order is now as desired
        assertEquals(2, names.size());
        assertFalse(names.contains("alpha"));
    }

    @Test
    void exploreUsingMethodReferenceOfSortText() {
        // Given: a populated collection of type String
        List<String> names = populateTestStringCollection();

        // Then: collection sequential order is per addition order
        assertEquals("Beta", names.get(0));

        // When: sorted via a method reference
        TextFilter filter = new TextFilter(); // NB: need an instance to reference a non-static method
        Collections.sort(names, filter::sortText);
        // Collections.sort(names, (s1,s2) -> filter.sortText(s1,s2)); // Equivalent using Lambda expression

        // Then: collection sequential order is now as desired
        assertEquals("Alpha", names.get(0));
    }

    @Test
    void exploreUsingMethodReferenceOfCompareToIgnoreCase() {
        // Given: a populated collection of type String
        List<String> names = populateTestStringCollection();

        // Then: collection sequential order is per addition order
        assertEquals("Beta", names.get(0));

        // When: sorted via a method reference
        Collections.sort(names, String::compareToIgnoreCase);


        // Then: collection sequential order is now as desired
        assertEquals("alpha", names.get(0));
    }

    private List<String> populateTestStringCollection() {
        List<String> names = new ArrayList<>();
        names.add("Beta");
        names.add("Gamma");
        names.add("alpha");
        names.add("Alpha");
        return names;
    }
}
