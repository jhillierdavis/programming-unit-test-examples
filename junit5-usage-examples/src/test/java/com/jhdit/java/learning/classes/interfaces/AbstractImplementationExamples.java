package com.jhdit.java.learning.classes.interfaces;

interface AnInterface {
    public abstract double calculateTax();
}

abstract class AbstractInterface implements AnInterface {
    public double calculateTax(double tax) {  return 0; }

    // NB: Does not have to implement the abstract interface method
}


class TaxCalculator extends AbstractInterface {
    @Override
    public double calculateTax() {
        return 1;
    }
}
