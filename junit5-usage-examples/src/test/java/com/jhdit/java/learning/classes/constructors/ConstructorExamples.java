package com.jhdit.java.learning.classes.constructors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImplicitConstructor {
    // No arg. constructor created implicitly (no need to write explicitly)
}

class NoImplicitConstructor {
    private int someValue; // defaults to 0

    NoImplicitConstructor(int someValue) {
        this.someValue = someValue;
    }
}

class ExplicitNoArgConstructor {
    public int someValue; // public for test access

    ExplicitNoArgConstructor() {}

    ExplicitNoArgConstructor(int someValue) {
        this.someValue = someValue;
    }
}


public class ConstructorExamples {

    @Test
    public void exploreImplicitConstructor() {
        ImplicitConstructor object = new ImplicitConstructor();

        assertNotNull(object);
        assertTrue(object instanceof ImplicitConstructor);
    }

    @Test
    public void exploreNoImplicitConstructor() {
        // NoImplicitConstructor object = new NoImplicitConstructor(); // Will NOT compile
        NoImplicitConstructor object = new NoImplicitConstructor(123);

        assertNotNull(object);
        assertTrue(object instanceof NoImplicitConstructor);
    }

    @Test
    public void exploreExplicitNoArgConstructor() {
        // When: instantiated with no-arg. constructor
        ExplicitNoArgConstructor object = new ExplicitNoArgConstructor();

        // Then: object created (without variables explicitly initialised)
        assertNotNull(object);
        assertTrue(object instanceof ExplicitNoArgConstructor);
        assertEquals(0, object.someValue);

        // When: instantiated with no-arg. constructor
        object = new ExplicitNoArgConstructor(987);

        // Then: object created (with variables explicitly initialised)
        assertNotNull(object);
        assertTrue(object instanceof ExplicitNoArgConstructor);
        assertNotNull(object.someValue);
        assertEquals(987, object.someValue);
    }
}

