package com.jhdit.java.learning.classes.immutability;

import com.jhdit.java.learning.classes.enums.Rating;

public class ImmutableSong {
    private final String trackName;
    private final Rating rating;

    public ImmutableSong(String trackName) {
        this(trackName, Rating.NOT_RATED);
    }

    public ImmutableSong(String trackName, Rating rating) {
        this.trackName = trackName;
        this.rating = rating;
    }

    public ImmutableSong applyMyRating(Rating rating)    {
        return new ImmutableSong(this.trackName, rating);
    }

    public String getTrackName() {
        return this.trackName;
    }

    public String getRating()  {
        return this.rating.toString();
    }
}
