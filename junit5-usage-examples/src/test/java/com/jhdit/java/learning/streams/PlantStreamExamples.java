package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.lang.management.BufferPoolMXBean;
import java.math.BigDecimal;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Planet {
    private BigDecimal milesFromSun;

    public Planet(String milesFromSun) {
        this.milesFromSun = new BigDecimal(milesFromSun);
    }

    public BigDecimal getMilesFromSun()  {
        return milesFromSun;
    }

    public static BigDecimal milesToKilometres(BigDecimal miles){
        BigDecimal scale =  new BigDecimal("1.60934");
        return miles.multiply(scale);
    }
}

public class PlantStreamExamples {
    @Test
    void explore()  {
        Planet earth = new Planet("93000000");

        // Invalid
        // Function<Planet, BigDecimal> lambda = Planet::milesToKilometres; // Incompatible types: Planet is not convertible to BigDecimal
        // Supplier<BigDecimal> lambda = ()::milesToKilometers; // Expression expected
        // Supplier<BigDecimal> lambda = earth.getMilesFromSun()::milesToKilometers; // Cannot resolve method 'milesToKilometers'
        // Function<BigDecimal> lambda = earth.getMilesFromSun()::milesToKilometers; // Wrong number of type arguments: 1; required: 2, Cannot resolve method 'milesToKilometers'
        // Function<BigDecimal, BigDecimal> lambda = earth.getMilesFromSun()::milesToKilometers; // Wrong number of type arguments: 1; required: 2, Cannot resolve method 'milesToKilometers'
        // Function<Planet, BigDecimal> lambda = earth.getMilesFromSun()::milesToKilometers; // Cannot resolve method 'milesToKilometers'

        Function<BigDecimal, BigDecimal> lambdaMilesToKm = Planet::milesToKilometres;
        assertEquals(149_668_620, lambdaMilesToKm.apply(earth.getMilesFromSun()).doubleValue());
    }
}
