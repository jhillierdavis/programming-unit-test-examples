package com.jhdit.java.learning.lambda_expressions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Examples of using Java Lambda expressions to replace anonymous inner classes
 * (examples of both provided for comparison)
 */

class Product {
    String name;
    double price;

    Product(String name, double price)    {
        this.name = name;
        this.price = price;
    }
}

public class LambdaExpressionExamples {

    private List<Product> setupProductList()    {
        // Setup: declare a list of products
        List<Product> products = new ArrayList<>();

        // Given: a populated list
        products.add(new Product("Gamma", 9.99));
        products.add(new Product("Beta", 1.99));
        products.add(new Product("Alpha", 14.99));

        return products;
    }

    @Test
    void usingAnonymousClassesForComparison() {
            // Setup: declare a list of products
            List<Product> products = setupProductList();

            // When: sort by name (using anonymous implementation of Comparator)
            Collections.sort(products, new Comparator<>() {
                @Override
                public int compare(Product p1, Product p2) {
                    return p1.name.compareTo(p2.name);
                }
            });

            // Then: sorted by name
            assertEquals("Alpha", products.get(0).name);

            // And when: sort by price
            Collections.sort(products, new Comparator<>() {
                @Override
                public int compare(Product p1, Product p2) {
                    return p1.price == p2.price ? 0 : ( p1.price > p2.price  ? 1 : -1);
                }
            });

            // Then: sorted by price
            assertEquals("Beta", products.get(0).name);
            assertEquals(1.99, products.get(0).price);

    }

    @Test
    void usingLambdaExpressionParameterAndBodyInstead()  {
        // Setup: declare a list of products
        List<Product> products = setupProductList();

        // When: sort by name (using anonymous implementation of Comparator)
        Collections.sort(products, (p1,p2) -> p1.name.compareTo(p2.name));

        // Then: sorted by name
        assertEquals("Alpha", products.get(0).name);

        // And when: sort by price
        Comparator<Product> lambda = (p1,p2) -> p1.price == p2.price ? 0 : ( p1.price > p2.price  ? 1 : -1);
        Collections.sort(products, lambda);

        // Then: sorted by price
        assertEquals("Beta", products.get(0).name);
        assertEquals(1.99, products.get(0).price);
    }
}
