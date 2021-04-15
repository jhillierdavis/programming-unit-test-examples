package com.jhdit.java.learning.classes.methods.virtualmethodinvocation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Java looks for overridden methods rather than necessarily use the one in the class that the code/compiler says we have (i.e. via its reference).
 */

class VirtualMethodInvocationExamples {

    @Test
    void explore()  {
        Dog dog = new Dog();
        Pet pet = dog;

        // Then: dog name is expected
        assertEquals("Fido", dog.name);

        // But: pet name variable remains 'Unnamed', even though pet references a Dog instance here!
        assertEquals("Unnamed", pet.name);

        // However: overridden methods are invoked (irrespective of type of instance reference)
        assertEquals("Fido", dog.getName());
        assertEquals("Fido", pet.getName());

        // And: superclass details remain accessible (if you want)
        assertEquals("Unnamed", dog.getSuperclassNameVariable());
        assertEquals("Unnamed", dog.invokeSuperclassNameMethod());
    }
}

abstract class Pet {
    String name = "Unnamed";

    public String getName()    {
        return name;
    }
}

class Dog extends Pet {
    String name = "Fido";

    @Override
    public String getName()    {
        return name;
    }

    public String getSuperclassNameVariable()    {
        return super.name;
    }

    public String invokeSuperclassNameMethod()    {
        return super.getName();
    }
}