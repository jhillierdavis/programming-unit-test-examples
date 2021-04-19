package com.jhdit.java.learning.concurrency;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcurrentStreamExamples {

    @Test
    void explore()  {
        Stream<String> stream = Stream.of("w", "o", "l", "f").parallel();
        SortedSet<String> set = stream.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);

        StringBuffer sb = new StringBuffer();
        for(String str: set)    {
            sb.append(str);
        }
        assertEquals("flow", sb.toString());
    }
}
