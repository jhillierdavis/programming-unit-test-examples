package com.jhdit.java.learning.classes.instance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * In 'x instanceof Y' checks the expression returns 'true' if the reference 'x':
 *
 * * is an instance of Y, a subclass of Y (direct or indirect)
 * * or a class that implements the Y interface (directly or indirectly)
 *
 * NB: if x is a NULL references the expressions returns false.
 */

public class InstanceOfExamples {

    @Test
    void exploreInstanceOfOperator()    {
        // Given: 2 instances of different classes with common parent classes/interfaces
        Hippo hippo = new Hippo();
        Rhino rhino = new Rhino();

        // Then: these pass the instanceof check (return 'true')
        assertTrue(hippo instanceof Animal);
        assertTrue(hippo instanceof HeavyLandAnimal);
        assertTrue(hippo instanceof Hippo);

        // Then: NULL fails instanceof check (returns 'false')
        Hippo nullRef = null;
        assertFalse(nullRef instanceof Hippo);

        // And: this will NOT compile - incompatible types caught by compiler (since can never pass 'is-a' relationship)
        // assertTrue(rhino instanceof Hippo);

        // And:
        assertTrue(rhino instanceof RareAnimal);
        assertFalse(hippo instanceof RareAnimal); // allows since subclass may implement interface (see next)
        hippo = new AlbinoHippo();
        assertTrue(hippo instanceof RareAnimal);
    }
}

// Some classes to use for testing
interface Animal {}
abstract class HeavyLandAnimal implements Animal {}
class Hippo extends HeavyLandAnimal {}

interface RareAnimal {}
class Rhino extends HeavyLandAnimal implements RareAnimal {}
class AlbinoHippo extends Hippo implements RareAnimal {}

