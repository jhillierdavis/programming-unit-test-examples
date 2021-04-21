package com.jhdit.java.learning.streams;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StreamAndCollectionExamples {
    public static Function<String, String> swap = s -> {
        System.out.println(s);
        if (s.equals("Australia"))  {
            return "New Zealand";
        } else {
            return s;
        }
    };

    @Test
    void explore()  {
        Set<String> islandNations = Set.of( "Japan", "Taiwan", "Cypus", "Cuba", "Australia" );



        islandNations = islandNations.stream()
                .map(swap)
                .map(n -> n.substring(0,1))
                .peek(s -> System.out.println(s))
                .collect(Collectors.toSet());

        StringBuilder sb = new StringBuilder();
        for (String s: islandNations)   {
            sb.append(s);
        }

        assertEquals("CTJN", sb.toString()); // Why that specific order?
    }
}
