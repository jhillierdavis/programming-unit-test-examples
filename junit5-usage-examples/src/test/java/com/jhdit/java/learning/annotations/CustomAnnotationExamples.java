package com.jhdit.java.learning.annotations;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

import static java.lang.annotation.ElementType.*;
import static org.junit.jupiter.api.Assertions.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = { FIELD, CONSTRUCTOR })
@interface CustomAnnotation {
    String owner(); // must be public (implicitly so)
    int priority() default 50; // Must have a default as not specified
}

@Deprecated
class Store    {
    @CustomAnnotation(owner="Audit", priority = 97)
    public String label;

    @CustomAnnotation(owner = "Test Suite")
    public Store(String label)  {
        this.label = label;
    }
}


public class CustomAnnotationExamples {

    @SuppressWarnings("deprecated")
    @Test
    void constructorCustomAnnotationMetaData()  {
        // Given: an object with annotations
        Store store = new Store("Local store");

        // When: obtain class meta-data
        Class<? extends Store> clazz = store.getClass();

        // Then: expected class level annotations are present (at runtime)
        assertTrue(clazz.isAnnotationPresent(Deprecated.class));
        assertFalse(clazz.isAnnotationPresent(CustomAnnotation.class));
    }

    @SuppressWarnings("deprecated")
    @Test
    void classLevelCustomAnnotationMetaData()  {
        // Given: an object with annotations
        Store store = new Store("Local store");

        // When: obtain class meta-data
        Class<? extends Store> clazz = store.getClass();

        // Then: expected method level annotations are present (at runtime, may require use of RetentionPolicy.RUNTIME!)
        assertEquals(1, (clazz.getConstructors()).length); // Single constructor, so array of size 1
        for (var constructor: clazz.getConstructors())  {
            // NB: Would have failed without use of RetentionPolicy.RUNTIME
            assertTrue(constructor.isAnnotationPresent(CustomAnnotation.class));
            CustomAnnotation customAnnotation = constructor.getAnnotation(CustomAnnotation.class);
            assertEquals("Test Suite", customAnnotation.owner());
            assertEquals(50, customAnnotation.priority());
        }
    }

    @SuppressWarnings("deprecated")
    @Test
    void fieldCustomAnnotationMetaData()  {
        // Given: an object with annotations
        Store store = new Store("Local store");

        // When: obtain class meta-data
        Class<? extends Store> clazz = store.getClass();

        // Then: expected field annotation is present & has expected values
        try {
            Field reflectionField = clazz.getField("label");
            assertTrue(reflectionField.isAnnotationPresent(CustomAnnotation.class));
            CustomAnnotation customAnnotation = reflectionField.getAnnotation(CustomAnnotation.class);
            assertEquals("Audit", customAnnotation.owner());
            assertEquals(97, customAnnotation.priority());
        } catch (NoSuchFieldException nsfe) {
            fail("Test data setup invalid!");
        }
    }
}
