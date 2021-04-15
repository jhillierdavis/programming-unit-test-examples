package com.jhdit.java.learning.designpatterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    // TODO
}
