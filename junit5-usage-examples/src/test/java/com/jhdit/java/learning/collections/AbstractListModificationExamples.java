package com.jhdit.java.learning.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AbstractListModificationExamples {

    @Test
    void explore()  {
        // TODO: Split into separate tests

        // Setup:
        List<Integer> list1 = new CopyOnWriteArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> list2 = Collections.synchronizedList(Arrays.asList(1, 2, 3, 4, 5, 6));

        // When:
        for (Integer item: list1) list1.add(5);

        // Then:
        assertEquals(12, list1.size()); // The original size has doubled

        // When: deleting
        for (Integer item : list1) list1.remove(0);
        assertEquals(0, list1.size()); // Emptied (copy on write list)

        // And: expect an exception here
        assertThrows(UnsupportedOperationException.class, () -> {
            for (Integer item : list2) list2.add(5);
            // java.util.AbstractList.remove is unsupported
        });

        // And: expect an exception here
        assertThrows(UnsupportedOperationException.class, () -> {
            for (Integer item : list2) list2.remove(0);
            // java.util.AbstractList.remove is unsupported
        });
    }


}
