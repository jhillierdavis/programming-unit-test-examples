package com.jhdit.java.learning.classes.interfaces.inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Subtype interface default method takes priority over a super-type default method.
 */

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

class MetalicColor implements Black, Red, Gold {}

abstract class Pink {
    public String getColor(){
        return "Pink";
    }
}

class BlendedColor extends Pink implements Black { }

public class InterfaceDefaultMethodInheritanceExamples {

    @Test
    void exploreOverriddenInterfaceDefault()  {
        MetalicColor color = new MetalicColor();

        assertEquals("Red", color.getColor());
        assertEquals("Gold", Gold.getColor());
    }

    @Test
    void exploreConcreteImplementationTakesPrecedence()  {
        BlendedColor color = new BlendedColor();

        assertEquals("Pink", color.getColor());
    }
}
