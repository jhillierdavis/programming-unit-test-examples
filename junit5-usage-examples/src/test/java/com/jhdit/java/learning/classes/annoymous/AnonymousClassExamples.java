package com.jhdit.java.learning.classes.annoymous;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Explore use of anonymous inner classes (using Comparator as an example)
 */

class Product {
    String name;
    double price;
    
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class AnonymousClassExamples {

    @Test
    void explore()  {
        // Setup: declare a list of products
        List<Product> products = new ArrayList<>();

        // Given: a populated list
        products.add(new Product("Gamma", 9.99));
        products.add(new Product("Beta", 1.99));
        products.add(new Product("Alpha", 14.99));

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
                if (p1.price == p2.price)   {
                    return 0;
                }
                return p1.price > p2.price ? 1 : -1;
            }
        });

        // Then: sorted by price
        assertEquals("Beta", products.get(0).name);
        assertEquals(1.99, products.get(0).price);
    }
}