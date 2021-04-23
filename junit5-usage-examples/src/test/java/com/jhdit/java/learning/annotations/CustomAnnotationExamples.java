package com.jhdit.java.learning.annotations;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// @Target(value = { METHOD }) // Invalid as not applied on a method in this example!
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { FIELD, CONSTRUCTOR })
@interface CustomAnnotation {
    String owner();
    int count() default 100; // Must have a default as not specified
}

@Deprecated
class Store    {
    public String desc;

    @CustomAnnotation(owner = "Sam")
    public Store(String desc)  {
        this.desc = desc;
    }
}

public class CustomAnnotationExamples {

    @Test
    void explore()  {
        // Given: an object with annotations
        Store store = new Store("Local store");

        // When: obtain class meta-data
        Class<? extends Store> clazz = store.getClass();

        // Then: expected class level annotations are present (at runtime)
        assertTrue(clazz.isAnnotationPresent(Deprecated.class));
        assertFalse(clazz.isAnnotationPresent(CustomAnnotation.class));

        // And: expected method level annotations are present (at runtime, may require use of RetentionPolicy.RUNTIME!)
        for (var constructor: clazz.getConstructors())  {
            // NB: Would have failed without use of RetentionPolicy.RUNTIME
            assertTrue(constructor.isAnnotationPresent(CustomAnnotation.class));
        }
    }
}
