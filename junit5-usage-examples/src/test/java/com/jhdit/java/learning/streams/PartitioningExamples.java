package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

interface Vehicle {
    String getName();
}

class AbstractVehicle implements Vehicle  {
    private String name;

    AbstractVehicle(String name)   {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}

class Car extends AbstractVehicle {
    Car(String name) {
        super(name);
    }
}

class Plane extends AbstractVehicle {
    Plane(String name) {
        super(name);
    }
}

/**
 * Examples of using Java Stream (& Collections) to partition (split into groups)
 */

public class PartitioningExamples {


    @Test
    void explorePartitioning()  {
        // Setup: List containing 2 types of vehicles (cars & planes)
        List<Vehicle> jamesBondVehicles = new ArrayList<>();
        Plane examplePlane = new Plane("Little Nellie");
        jamesBondVehicles.add(examplePlane);
        Car exampleCar = new Car("Aston Martin DB5");
        jamesBondVehicles.add(exampleCar);
        jamesBondVehicles.add(new Plane("BD-5J Acrostar Microjet"));
        jamesBondVehicles.add(new Car("Lotus Esprit"));
        jamesBondVehicles.add(new Car("Aston Martin DBS")); // e.g. On Her Majesty's Secret Service

        // When: Partitioned (into 2 groups) around a condition (e.g. whether a car)
        Map<Boolean, List<Vehicle>> map = jamesBondVehicles.stream().collect(Collectors.partitioningBy(v -> v instanceof Car));
        List<Vehicle> cars = map.get(Boolean.TRUE);
        List<Vehicle> planes = map.get(Boolean.FALSE);

        // Then: partitions are as expected
        assertTrue(cars.contains(exampleCar));
        assertEquals(3, cars.size());
        assertTrue(planes.contains(examplePlane));
        assertEquals(2, planes.size());
    }
}
