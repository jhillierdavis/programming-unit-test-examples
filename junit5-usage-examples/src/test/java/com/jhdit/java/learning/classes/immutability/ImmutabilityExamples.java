package com.jhdit.java.learning.classes.immutability;

import com.jhdit.java.learning.classes.enums.Rating;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImmutabilityExamples {

    @Test
    public void exploreImmutableExample() {
        // Given: an immutable object with a rating applied
        ImmutableSong song = new ImmutableSong("Tune");
        ImmutableSong favourite = song.applyMyRating(Rating.FIVE_STAR);

        // Check: the rated object is not the original
        assertEquals(song.getTrackName(), favourite.getTrackName());
        assertNotEquals(song.getRating(), favourite.getRating());
        assertNotEquals(song, favourite);

    }
}
