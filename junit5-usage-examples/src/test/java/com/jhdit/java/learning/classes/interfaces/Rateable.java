package com.jhdit.java.learning.classes.interfaces;

import com.jhdit.java.learning.classes.enums.Rating;

/**
 * NB: A functional interface defines a single abstract operation.
 *
 * @param <T>
 */

@FunctionalInterface // Triggers a compiler error if have more than one abstract method!
interface Rateable<T> { // NB: Implicitly public (declaration redundant)
    Rating DEFAULT_RATING = Rating.NOT_RATED; // NB:Implicitly public, static & final (declaration redundant)

    default Rating getRating()   {
        return DEFAULT_RATING;
    }

    T applyRating(Rating rating); // public & abstract implicitly!

    default T applyRating(int stars) { // NB: Implicitly public (declaration redundant)
        return applyRating( convert(stars) );
    }

    static Rating convert(int stars) {
        Rating[] enumValues = Rating.values();

        return 0 <= stars && 5 > stars ? Rating.values()[stars] : DEFAULT_RATING;
    }
}
