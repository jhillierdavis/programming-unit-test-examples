package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Examples of Java Stream collections using FlatMapping
 */


public class FlatMappingExamples {

    @Test
    void exploreFlatMappingWithEvenNumbers() {
        // Given: a (small) set of integers find the even set
        Set<Integer> evenNumbers = Stream.of(List.of(1, 2, 3, 4), List.of(3, 4, 5, 6, 7, 8, 9))
                .collect(
                        Collectors.flatMapping(
                                l -> l.stream()
                                        .filter(i -> i % 2 == 0),
                                Collectors.toSet() // NB: Use Set instead of List for uniqueness
                        )
                );

        // Then: even numbers set is as expected
        List<Integer> expectedEvenNumbers = List.of(2,4,6,8);
        assertEquals(4, evenNumbers.size());
        assertTrue(evenNumbers.containsAll(expectedEvenNumbers));
    }

    @Test
    void exploreCollectorsFlatMapping() {
        // Setup: some test orders (for 2 customers: Anne & Bob)
        Customer anne = new Customer("Anne");
        Customer bob = new Customer("Bob");
        Item coffee = new Item("Coffee", 1.50);
        Item tea = new Item("Tea", 1.25);
        Item cake = new Item("Cake", 2.99);

        LocalDate now = LocalDate.now();
        Order order1 = new Order(now.minusDays(2), anne, List.of(coffee));
        Order order2 = new Order(now.minusDays(2), bob, List.of(coffee));
        Order order3 = new Order(now.minusDays(1), anne, List.of(tea, cake));
        Order order4 = new Order(now.minusDays(1), bob, List.of(coffee, cake));

        List<Order> orders = List.of(order1, order2, order3, order4);


        // When: use Collectors.groupingBy & Collectors.flatMapping to obtain distinct items bought per customers
        Map<Customer, Set<Item>> customerItems = orders.stream().collect(
                Collectors.groupingBy(
                        Order::getCustomer,
                        Collectors.flatMapping(order -> order.getItems().stream(), Collectors.toSet())
                )
        );

        // Then: Anne's distinct items (across all orders) are obtained
        Set<Item> flatMapAnneItems = customerItems.get(anne);
        assertEquals(3, flatMapAnneItems.size());
        assertTrue(flatMapAnneItems.containsAll(List.of(tea, coffee, cake)));

        // And: Bob's distinct items (across all orders) are obtained
        Set<Item> flatMapBobItems = customerItems.get(bob);
        assertEquals(2, flatMapBobItems.size());
        assertTrue(flatMapBobItems.containsAll(List.of(coffee, cake)));
    }
}

/**
 * Simple test data classes
 */

class Customer {
    private final String name;

    Customer(String name) {
        this.name = name;
    }
}


class Item {
    private final String name;
    private final Double price;

    Item(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return this.name;
    }
}

class Order {
    private LocalDate localDate;
    private Customer customer;
    List<Item> items;

    public Order(LocalDate localDate, Customer customer, List<Item> items) {
        this.localDate = localDate;
        this.customer = customer;
        this.items = items;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public List<Item> getItems() {
        return this.items;
    }
}