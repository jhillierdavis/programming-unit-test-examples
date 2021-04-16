package com.jhdit.java.learning.designpatterns;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * ImmutableObjects - create read-only objects that can be safely shared & used by multiple classes / threads.
 *
 * Apply common immutable strategy:
 *
 * 1) Use constructor to set all properties of the object
 * 2) Mark all the instance variables private & final
 * 3) Do NOT define any setter methods
 * 4) Do NOT allow referenced mutable objects to be modified or accessed directly.
 * 5) Prevent methods from being overridden (e.g. declare class final to prevent inheritance)
 */

final class Seal {
    private final String name;
    private final List<Seal> friends;

    Seal(final String name, final List<Seal> friends) {
        if (null == name) {
            throw new IllegalArgumentException("NULL name!");
        }
        if (null == friends)    {
            throw new IllegalArgumentException("NULL friends!");
        }
        this.name = name;
        this.friends = Collections.unmodifiableList(new ArrayList<Seal>(friends));
    }

    public String getName() { return this.name; }
    public List<Seal> getFriends() { return this.friends; }
}

public class ImmutableObjectPatternExamples {
    @Test
    void explore()  {
        // Setup:
        Seal luca = new Seal("Luca", new ArrayList<Seal>());
        Seal louise = new Seal("Luca", new ArrayList<Seal>());
        Seal joe = new Seal("Joe", Arrays.asList(new Seal[] {luca, louise }));

        // Check: immutability of friend list (instead create a new object)
        List<Seal> friends = joe.getFriends();
        assertThrows(UnsupportedOperationException.class, () ->
        {
            Seal steve = new Seal("Steve", new ArrayList<Seal>());
            friends.add( steve );

        });
    }
}
