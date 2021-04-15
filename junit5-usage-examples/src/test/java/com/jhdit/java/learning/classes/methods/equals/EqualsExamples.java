package com.jhdit.java.learning.classes.methods.equals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Examples of overriding Object.equals correctly & incorrectly (e.g. inadvertently).
 */


public class EqualsExamples {

    @Test
    void exploreProblematicEquals()  {
        NotOverridingEquals orig = new NotOverridingEquals(123);
        NotOverridingEquals same = new NotOverridingEquals(123);
        NotOverridingEquals diff = new NotOverridingEquals(987);

        // Then: as expected / intended
        assertTrue(orig.equals(orig));
        assertTrue(orig.equals(same));
        assertFalse(orig.equals(diff));
        assertTrue(orig.equals((Object)orig));
        assertFalse(orig.equals((Object)diff));

        // However: this does not work!
        assertFalse(orig.equals((Object)same));
    }

    @Test
    void exploreFixedEquals()  {
        FixesEquals orig = new FixesEquals(123);
        FixesEquals same = new FixesEquals(123);
        FixesEquals diff = new FixesEquals(987);

        // Then: as expected / intended
        assertTrue(orig.equals(orig));
        assertTrue(orig.equals(same));
        assertFalse(orig.equals(diff));
        assertTrue(orig.equals((Object)orig));
        assertFalse(orig.equals((Object)diff));

        // However: now (unlike NotOverridingEquals example) this does work also (since uses overridden equals() method!)
        assertTrue(orig.equals((Object)same));
        assertTrue(orig.equals((NotOverridingEquals)same));
    }
}

class NotOverridingEquals    {
    final int id;

    NotOverridingEquals(int id)   {
        this.id = id;
    }

    /**
     * Does NOT override Object.equals! (since parameter is not of type Object!)
     * NB: Use Override annotation to protect against inadvertent mistake
     * @param other NotOverridingEquals instance (NOT Object!)
     * @return True if equivalent
     */
    public boolean equals(NotOverridingEquals other) {
        if (other == null) {
            return false;
        }
        return this.id == other.id;
    }
}

class FixesEquals extends NotOverridingEquals {

    FixesEquals(int id) {
        super(id);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NotOverridingEquals))    {
            return false;
        }
        return this.id == ((NotOverridingEquals) o).id;
    }
}
