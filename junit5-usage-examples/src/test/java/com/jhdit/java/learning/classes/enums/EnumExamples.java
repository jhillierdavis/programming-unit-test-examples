package com.jhdit.java.learning.classes.enums;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChessGameUnit {
    enum Side { WHITE, BLACK }
    enum Unit {
        KING("King", Integer.MAX_VALUE),
        QUEEN("Queen", 9),
        BISHOP("Bishop",3),
        KNIGHT("Horse",3), // use 'Horse' rather than 'Knight' to show can differ from enum name
        ROOK("Rook",5),
        PAWN("Pawn", 1);
        String label;
        int relativeValue;

        Unit(String label, int value) {
            this.label = label;
            this.relativeValue = value;
        }
    }
    private Side side;
    private Unit unit;

    ChessGameUnit(Side side, Unit unit) {
        this.side = side;
        this.unit = unit;
    }

    public Side getSide() {
        return  this.side;
    }

    public Unit getUnit() {
        return  this.unit;
    }

}

public class EnumExamples {

    @Test
    public void exploreChessPieceEnum()  {
        // Given: a constructed chess game unit
        ChessGameUnit piece = new ChessGameUnit(ChessGameUnit.Side.WHITE, ChessGameUnit.Unit.KNIGHT);

        // Then: side & unit are expected enums
        assertEquals(ChessGameUnit.Side.WHITE, piece.getSide());
        assertEquals(ChessGameUnit.Unit.KNIGHT, piece.getUnit());
        assertEquals("Horse", piece.getUnit().label);
        assertEquals(3, piece.getUnit().relativeValue);
    }

    @Test
    public void exploreRatingEnum() {
        // Given: a rated product
        RatedProduct product = new RatedProduct(101, "An item", 3.99, Rating.FOUR_STAR);

        // Then: the rating can be retrieved as expected
//        System.out.println("Rated product: " + product);
        assertEquals(Rating.FOUR_STAR, product.getRating());

        // And: string representation includes star rating characters
        assertEquals("RatedProduct {id=101 , name=An item , price=3.99 , rating=★★★★☆}", product.toString());

        // When: we create an unrated product
        product = new RatedProduct(202, "A new item", 5.50);

        // Then: rating is NO_RATING & display has no stars
        assertEquals(Rating.NOT_RATED, product.getRating());
        String str = product.toString();
        // assertEquals("RatedProduct {id=202 , name=A new item , price=5.5 , rating=☆☆☆☆☆}", product.toString());
        assertTrue(str.contains("rating=☆☆☆☆☆"));
    }
}
