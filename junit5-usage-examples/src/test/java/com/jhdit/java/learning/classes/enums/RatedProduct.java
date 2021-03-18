package com.jhdit.java.learning.classes.enums;
import com.jhdit.java.learning.classes.javadoc.DocumentedProduct;

import java.math.BigDecimal;

import static com.jhdit.java.learning.classes.enums.Rating.*;

class RatedProduct extends DocumentedProduct {
    private Rating rating;

    public RatedProduct(int id, String name, double price)  {
        this.setId(id);
        this.setName(name);
        this.setPrice(BigDecimal.valueOf(price));
        this.rating = NOT_RATED;
    }

    public RatedProduct(int id, String name, double price, Rating rating)  {
        this(id, name, price); // call other constructor (NB: must be first call!)
        this.rating = rating;
    }

    public Rating getRating() {
        return this.rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "RatedProduct {" +
                "id=" + this.getId() +
                " , " +
                "name=" + this.getName() +
                " , " +
                "price=" + this.getPrice() +
                " , " +
                "rating=" + rating +
                '}';
    }
}
