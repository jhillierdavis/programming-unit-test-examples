package com.jhdit.java.learning.classes.methods.overloading;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example method overloading see {@link #setPrice setPrice() }
 */


class Product {
    private BigDecimal price;
    private BigDecimal discount = BigDecimal.ZERO;

    public void setPrice(double price) {
        this.price = BigDecimal.valueOf(price);
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPrice(BigDecimal price, BigDecimal discount) {
        this.price = price;
        this.discount = discount;
    }

    public BigDecimal getPrice() { return this.price; }

    public BigDecimal getDiscount() { return this.discount; }
}

public class MethodOverloadingExamples {
    @Test
    public void callOverloadedMethods()   {
        Product product = new Product();

        // Then: price can be set via the method name 'price()'
        product.setPrice(19.99);
        assertEquals(19.99, product.getPrice().doubleValue());
        assertEquals(0, product.getDiscount().doubleValue());

        // And: price can be set using BigDecimal, via the same method name 'price()'
        product.setPrice(new BigDecimal(24.99));
        assertEquals(24.99, product.getPrice().doubleValue());
        assertEquals(0, product.getDiscount().doubleValue());

        // And: price & discount can be set together, via the same method name 'price()'
        product.setPrice(new BigDecimal(29.99), new BigDecimal(0.2));
        assertEquals(29.99, product.getPrice().doubleValue());
        assertEquals(0.2, product.getDiscount().doubleValue());
    }
}
