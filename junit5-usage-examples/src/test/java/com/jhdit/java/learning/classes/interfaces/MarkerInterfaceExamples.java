package com.jhdit.java.learning.classes.interfaces;

import org.junit.jupiter.api.Test;

import java.io.Serializable;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Marker interface examples.
 */

class MySerializableClass implements Serializable {}

public class MarkerInterfaceExamples {

    @Test
    public void explore()   {
        // Given: an instance
        MySerializableClass serializable = new MySerializableClass();

        // Then: class has expected marker interface
        Class[] classes = serializable.getClass().getInterfaces();
        assertEquals("java.io.Serializable", classes[0].getName());
    }
}
