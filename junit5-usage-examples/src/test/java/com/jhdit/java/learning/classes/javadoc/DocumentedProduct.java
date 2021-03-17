package com.jhdit.java.learning.classes.javadoc;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

/**
 * {@code DocumentedProduct} class represents properties and behaviours of product objects in the product catalogue.
 * <br>
 * Each product has an id, name and price.
 * <br>
 * Each product can have a discount, calculated based on a {@link #DISCOUNT_RATE discount rate}
 * @Version 1.0
 * @author John Smith
 */

public class DocumentedProduct {
    /**
     * A constant that defines a {@link java.math.BigDecimal BigDecimal} value
     * of the discount rate
     * <br>
     * Discount rate is 10%
     */
    public final static BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);
    private int id;
    private String name;
    private BigDecimal price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Calculates discount based on a product price and {@link #DISCOUNT_RATE discount rate}
     * @return a {@link java.math.BigDecimal BigDecimal} value of the discount
     */

    public BigDecimal getDiscount()    {
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    public BigDecimal getDiscountPrice()    {
        return price.subtract(this.getDiscount());
    }
}
