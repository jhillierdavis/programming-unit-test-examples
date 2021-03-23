package com.jhdit.java.learning.classes.generics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class WrapperExamples {

    @Test
    public void exploreObjectWrapper()  {
        // Setup:
        String originalString = "A String";
        Integer originalInteger = Integer.valueOf(123);

        // Given: an object wrapper
        ObjectWrapper strWrapper  = new ObjectWrapper(originalString);
        ObjectWrapper integerWrapper  = new ObjectWrapper(Integer.valueOf(originalInteger));

        // Then: can unwrap to a object (not the subclass type directly)
        Object unwrapped = strWrapper.unwrap();
        assertEquals(originalString, unwrapped);
        assertTrue(unwrapped instanceof String);

        // However: need to cast to use subclass features
        String unwrappedString = (String) unwrapped;
        assertEquals("a string", unwrappedString.toLowerCase());
    }

    @Test
    public void exploreGenericWrapper() {
        // Setup: test object
        String originalString = "A String";
        Integer originalInteger = Integer.valueOf(123);

        // Given: a generic wrapper
        GenericWrapper<String> strWrapper  = new GenericWrapper<>(originalString);
        GenericWrapper<Integer> integerWrapper  = new GenericWrapper<>(originalInteger);

        // Then: we can unwrap directly to the class type (no casting required) e.g. String
        String unwrapped = strWrapper.unwrap();
        assertEquals(originalString, unwrapped);
        assertTrue(unwrapped instanceof String);
        assertEquals("a string", unwrapped.toLowerCase());

        // And: similarly for other types (e.g. Integer)
        Integer integerUnwrapped = integerWrapper.unwrap();
        assertEquals(123, integerUnwrapped);
        assertEquals(Integer.class, integerUnwrapped.getClass());
    }
}
