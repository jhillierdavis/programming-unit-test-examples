package com.jhdit.java.learning.classes.interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface Black   {
    default String getColor() {
        return "Black";
    }
}

interface Red extends Black {
    @Override
    default String getColor()   {
        return "Red";
    }
}

interface Gold {
    static String getColor()  {
        return "Gold";
    }
}

class Color implements Black, Red, Gold {}

public class InterfaceInheritanceExamples {

    @Test
    void explore()  {
        Color color = new Color();

        assertEquals("Red", color.getColor());
        assertEquals("Gold", Gold.getColor());
    }
}
