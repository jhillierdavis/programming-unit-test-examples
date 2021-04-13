package com.jhdit.java.learning.annotations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Examples of annotations that ask compiler to check the design (will not compile if false) e.g:
 *
 * * FunctionalInterface
 * * Override
 */

@FunctionalInterface //
interface MyFunctionalInterface {
    void oneAbstractMethod();

    // void anotherAbstractMethod(); // Would trigger a compiler error due to @FunctionalInterface check
}

class SubclassWithMethodLevelAnnotation {
    private int id;

    SubclassWithMethodLevelAnnotation(int id)    {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SubclassWithMethodLevelAnnotation)  {
            return equals((SubclassWithMethodLevelAnnotation) o);
        }
        return false;
    }

    // @Override // Would trigger a compiler error if no  override method in parent (as here)
    public boolean equals(SubclassWithMethodLevelAnnotation s)   {
        return this.id == s.id;
    }
}

public class AnnotationsThatValidateDesignExamples {
    @Test
    void testEquals() {
        // Setup:
        SubclassWithMethodLevelAnnotation s1 = new SubclassWithMethodLevelAnnotation(1);
        SubclassWithMethodLevelAnnotation s2 = new SubclassWithMethodLevelAnnotation(2);
        Object o2 = (Object) s2;

        // Check: equals works as expected
        assertFalse(s2.equals(s1));
        assertTrue(s2.equals(o2));
    }
}
