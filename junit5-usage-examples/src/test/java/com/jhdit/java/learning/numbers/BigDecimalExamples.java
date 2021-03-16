package com.jhdit.java.learning.numbers;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigDecimalExamples {

    @Test
    public void exploreSetScale() {
        // Setup: given some BigDecimal objects (representing fiscal values)
        BigDecimal price = new BigDecimal(12.99); // Albeit, string constructor actually recommended for predictability of representation
        BigDecimal taxRate = new BigDecimal(0.2);

        // When: price including tax is calculated (to 2 decimal places)
        BigDecimal priceIncTax = price.add(price.multiply(taxRate)).setScale(2, RoundingMode.HALF_UP);

        // Then: result is as expected
        assertEquals("15.59", priceIncTax.toString() );
    }
}
