package com.jhdit.java.learning.concurrency;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * For CopyOnWrite collections:
 *
 * any iterator established prior to the modification will not see the changes,
 * but instead will iterate over the original elements prior to the modification.
 */

public class CopyOnWriteArrayListExamples {

    private void populateGivenList(List<Integer> list)    {
        list.add(4);
        list.add(2);
        list.add(8);
    }

    @Test
    void exploreAddWithIterator()   {
        // Given: a populated copy on write list
        List<Integer> cowList = new CopyOnWriteArrayList<>();
        populateGivenList(cowList);

        // When: an iterator is obtained, then the iterator reference remains a snapshot
        Iterator<Integer> it = cowList.iterator();
        cowList.add(7);

        // Then: count of iterable items remains 2 (not updated to 3)
        int count = 0;
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
            count++;
        }
        System.out.println();
        assertEquals(3, count);
        assertEquals(4, cowList.size());
    }

    @Test
    void exploreRemoveWithIterator()    {
        // Given: a populated copy on write list
        List<Integer> cowList = new CopyOnWriteArrayList<>();
        populateGivenList(cowList);

        // When: an iterator is obtained, then the iterator reference remains a snapshot
        Iterator<Integer> it = cowList.iterator();
        cowList.remove(2);

        // Then: count of iterable items remains 2 (not updated to 3)
        int count = 0;
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
            count++;
        }
        System.out.println();
        assertEquals(3, count);
        assertEquals(2, cowList.size());
    }


    @Test
    void addWithArrayListForComparisonToCopyOnWrite()    {
        // Given: a populated copy on write list
        List<Integer> list = new ArrayList<>();
        populateGivenList(list);

        // When: an iterator is obtained, then the iterator reference remains a snapshot
        Iterator<Integer> it = list.iterator();
        list.add(7);

        assertThrows(ConcurrentModificationException.class, () -> {
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
        });
    }

    @Test
    void removeWithArrayListForComparisonToCopyOnWrite()    {
        // Given: a populated copy on write list
        List<Integer> list = new ArrayList<>();
        populateGivenList(list);

        // When: an iterator is obtained, then the iterator reference remains a snapshot
        Iterator<Integer> it = list.iterator();
        list.remove(2);

        assertThrows(ConcurrentModificationException.class, () -> {
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
        });
    }
}
