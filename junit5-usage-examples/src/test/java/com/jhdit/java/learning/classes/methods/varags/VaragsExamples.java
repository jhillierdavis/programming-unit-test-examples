package com.jhdit.java.learning.classes.methods.varags;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class Product {
    // use protected to allow unit test access
    protected BigDecimal price;
    protected BigDecimal discount;
    protected BigDecimal tax;

    /**
     * Method that accepts variable length parameters
     * @param values vararg
     */

    public void setFiscalValues(double... values)    {
        switch(values.length)   {
            case 3:
                this.tax = BigDecimal.valueOf(values[2]);
            case 2:
                this.discount = BigDecimal.valueOf(values[1]);
            case 1:
                this.price = BigDecimal.valueOf(values[0]);
        }
    }
}

public class VaragsExamples {

    @Test
    public void useVarargs()    {
        // Given: an object (with a vararg method)
        Product product = new Product();

        // Check: set just price
        product.setFiscalValues(0.99);
        assertEquals(0.99, product.price.doubleValue());
        assertNull(product.discount);
        assertNull(product.tax);

        // When: set price & discount
        product.setFiscalValues(1.99, 0.10);
        assertEquals(1.99, product.price.doubleValue());
        assertEquals(0.1, product.discount.doubleValue());
        assertNull(product.tax);

        // When: set price, discount & tax
        product.setFiscalValues(2.99, 0.1, 0.05);
        assertEquals(2.99, product.price.doubleValue());
        assertEquals(0.1, product.discount.doubleValue());
        assertEquals(0.05, product.tax.doubleValue());
    }

}
