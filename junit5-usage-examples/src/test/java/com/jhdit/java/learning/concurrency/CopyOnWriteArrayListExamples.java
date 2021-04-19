package com.jhdit.java.learning.concurrency;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * For CopyOnWrite collections:
 *
 * any iterator established prior to the modification will not see the changes,
 * but instead will iterate over the original elements prior to the modification.
 */

public class CopyOnWriteArrayListExamples {

    @Test
    void exploreAddWithIterator()   {
        // Given: a populated copy on write list
        CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();
        cowList.add(4);
        cowList.add(2);

        // When: an iterator is obtained, then the iterator reference remains a snapshot
        Iterator<Integer> it = cowList.iterator();
        cowList.add(6);

        // Then: count of iterable items remains 2 (not updated to 3)
        int count = 0;
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
            count++;
        }
        System.out.println();
        assertEquals(2, count);
        assertEquals(3, cowList.size());
    }

    @Test
    void exploreRemoveWithIterator()    {
        // Given: a populated copy on write list
        CopyOnWriteArrayList<Integer> cowList = new CopyOnWriteArrayList<>();
        cowList.add(4);
        cowList.add(2);
        cowList.add(6);

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
}
