package com.jhdit.java.learning.classes;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyProduct {
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1); // Constant (for 10% discount)
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

    public BigDecimal getDiscount()    {
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    public BigDecimal getDiscountPrice()    {
        return price.subtract(this.getDiscount());
    }
}

public class ClassExamples {

    @Test
    public void shopWithDiscount()  {
        // Given: an instantiated product
        MyProduct p1 = new MyProduct();
        p1.setId(101);
        p1.setName("Tea");
        p1.setPrice(BigDecimal.valueOf(1.99));

        // Then: discounts are calculated correctly
        assertEquals(0.2, p1.getDiscount().doubleValue());
        assertEquals(1.79, p1.getDiscountPrice().doubleValue());
        assertEquals("1.79", p1.getDiscountPrice().toString());
    }
}
