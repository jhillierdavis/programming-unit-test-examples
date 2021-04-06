package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Food {
    private final String name;
    private final LocalDate bestBefore;

    Food(String name, LocalDate bestBefore) {
        this.name = name;
        this.bestBefore = bestBefore;
    }

    String getName() {
        return this.name;
    }

    LocalDate getBestBefore() {
        return this.bestBefore;
    }
}

public class GroupingExamples {
    @Test
    void exploreGrouping() {
        // Setup: a list of food with name & best before date
        LocalDate today = LocalDate.now();
        List<Food> foods = new ArrayList<>();
        LocalDate bestBeforeOneWeek = today.plusDays(7);
        Food milk = new Food("Milk", bestBeforeOneWeek);
        foods.add(milk);
        foods.add(new Food("Meat", today.plusDays(3)));
        Food bread = new Food("Bread", bestBeforeOneWeek);
        foods.add(bread);
        Food honey = new Food("Honey", today.plusDays(356));
        foods.add(honey);

        // When: grouping by a criteria (e.g. best before date)
        Map<LocalDate, List<Food>> dateGroupMap = foods.stream().collect(
                Collectors.groupingBy( f -> f.getBestBefore() )
        );

        // Then: grouping by date are returned
        List<Food> oneWeekFoods = dateGroupMap.get(bestBeforeOneWeek);
        assertEquals(2, oneWeekFoods.size());
        assertTrue(oneWeekFoods.contains(bread));
        assertTrue(oneWeekFoods.contains(milk));

        // And: further grouping
        List<Food> oneYearFoods = dateGroupMap.get(honey.getBestBefore());
        assertEquals(1, oneYearFoods.size());
        Optional<Food> first = oneYearFoods.stream().findFirst();
        assertEquals("Honey", first.isPresent() ? first.get().getName() : "");
        assertTrue(oneYearFoods.contains(honey));
    }
}
