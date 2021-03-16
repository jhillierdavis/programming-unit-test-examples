package com.jhdit.java.learning.primitives;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Primitive (non-object) type examples e.g. boolean, byte, int, float, double
 */

public class PrimitiveTypeExamples {

    @DisplayName("Different ways to initialise char variables values")
    @Test
    public void testCharInitialisation() {
        // Given: different ways of assigning the letter 'a'
        char charLetterA = 'a';
        char charLetterAasAscii = '\141';
        char charLetterAasUnicode = '\u0061';

        // Check: that they are equivalent
        assert (charLetterA == 'a');
        assert (charLetterA == charLetterAasAscii);
        assert (charLetterA == charLetterAasUnicode);
        assert ((int) charLetterA == 97); // 97 in Decimal == 141 in Octal == 61 in Hex
    }

    @DisplayName("Increment char variables values")
    @Test
    public void incrementLetter()   {
        // Given: a letter
        int ch = 'k';

        // Then: incrementing / decrementing gives the letter after / before
        assertSame('l', (char) ++ch);
        assertSame('k', (char) --ch);
        assertSame('j', (char) --ch);
    }

    private char customLetterCaseToggle(char letter)    {
        int shift = 0;
        if (letter >= 'a' && letter <= 'z') {
            shift = -32; // ('A' - 'a')  = -32
        } else if (letter >= 'A' && letter <= 'Z')  {
            shift = 32;
        }
        return (char) ((int)letter + shift);
    }

    @Test
    public void customLetterCaseToggleTest()   {
        // Check: Letter case is toggled
        assert('A' == customLetterCaseToggle('a') );
        assert('z' == customLetterCaseToggle('Z') );
        assert('m' == customLetterCaseToggle('M') );

        // And: Other characters remain unchanged
        assert('*' == customLetterCaseToggle('*'));
        assert('!' == customLetterCaseToggle('!'));
    }
}
