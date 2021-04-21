package com.jhdit.java.learning.classes.interfaces;

interface TestInterface {
    double taxRate = 2.0; // Implicitly static & final!

/*
    default void increaseTax()  {
        taxRate = taxRate + 0.1; // Cannot assign a value to final variable 'taxRate'!
    }
    static void increaseTaxRate()   {
        taxRate = taxRate + 0.1; // Cannot assign a value to final variable 'taxRate'!
    }

 */
}

public class DefaultMethodsAndStaticAccessExamples {
}
