package com.jhdit.java.learning.classes.nested;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OuterWrapper {
    public static class PublicStaticNested {
        // Code of the nested class
    }
}

class OuterFactory {
    public static PrivateStaticNested createInstance() {
        return new PrivateStaticNested();
    }

    /**
     * NB: Class can only be references inside the 'OuterFactory' class!
     */

    private static class PrivateStaticNested  {
        private String description;
        // Code of the nested class
    }
}

public class StaticNestedExamples {

    @Test
    public void exploreDirectInstantiation()   {
        // Given:
        OuterWrapper.PublicStaticNested n = new OuterWrapper.PublicStaticNested();

        // Then:
        assertTrue(n instanceof OuterWrapper.PublicStaticNested);
    }

    @Test
    public void exploreFactoryMethodInstantiation()   {
        // Given:
        Object obj = OuterFactory.createInstance();

        // Then:
        assertEquals("PrivateStaticNested", obj.getClass().getSimpleName() );
        // assertTrue(obj instanceof OuterFactory.PrivateStaticNested) // NB: PrivateStaticNested not visible!
    }
}
