package com.jhdit.java.learning.classes.nested;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Product {
    private String name;
    Product(String name)    {
        this.name = name;
    }

    String getName()    {
        return this.name;
    }
    // Other methods not implemented (just an example)
}

class Basket {
    private Set<BasketItem> items = new HashSet<>();

    class BasketItem {
        private Product product;
        private int quantity;

        private BasketItem(Product product, int quantity)   {
            this.product = product;
            this.quantity = quantity;
        }

        private void incrementQuantity() {
            this.quantity += 1;
        }

        // Other methods not implemented (just an example)
    }

    private BasketItem findItemByName(String name)   {
        for (BasketItem item: items)    {
            if (item.product.getName() == name) {
                return item;
            }
        }
        return null;
    }

    void addBasketItem(String name) {
        BasketItem item = findItemByName(name);
        if (null != item)   {
            item.incrementQuantity();
            return;
        }
        items.add(new BasketItem(new Product(name), 1));
    }

    int getTotalQuantity()  {
        int total = 0;
        for (BasketItem item: items)    {
            total += item.quantity;
        }
        return total;
    }

    int getQuantity(String name) {
        BasketItem item = findItemByName(name);
        return null != item ? item.quantity : 0;
    }
}


public class MemberInnerClassExamples {

    @Test
    public void explore()   {
        // Given: a (v. simple) shopping basket implementation
        Basket basket = new Basket();

        // When: items are added to the basket
        basket.addBasketItem("Alpha");
        basket.addBasketItem("Beta");
        basket.addBasketItem("Gamma");
        basket.addBasketItem("Alpha");

        // Then: basket quantities are as explected
        assertEquals(4, basket.getTotalQuantity());
        assertEquals(2, basket.getQuantity("Alpha"));
        assertEquals(1, basket.getQuantity("Beta"));
    }
}
