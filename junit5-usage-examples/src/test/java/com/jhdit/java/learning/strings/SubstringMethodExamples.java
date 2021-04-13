package com.jhdit.java.learning.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Remember that String.substring():
 *
 * * Includes the starting index content (starting from an index of zero!)
 * * EXCLUDES the (optional) ending index content
 */

public class SubstringMethodExamples {

    @Test
    void exploreFromSubstringDocumentation() {
        assertEquals("urge", "hamburger".substring(4, 8));
        assertEquals("mile", "smiles".substring(1, 5));
    }

    @Test
    void explore()   {
        // Given:
        String mammal = "DOLPHIN";

        // When:
        String modified = mammal.substring(2, mammal.indexOf('I')); // "LPH"
        modified += "x" + mammal.substring(4);

        // Then:
        assertEquals("LPHxHIN", modified);

        // Because:
        assertEquals("LPH", mammal.substring(2, mammal.indexOf('I')));
        assertEquals("HIN", mammal.substring(4));
    }
}
