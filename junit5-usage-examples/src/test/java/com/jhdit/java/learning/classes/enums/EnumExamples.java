package com.jhdit.java.learning.classes.enums;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void exploreEnums()  {
        // Given: a constructed chess game unit
        ChessGameUnit piece = new ChessGameUnit(ChessGameUnit.Side.WHITE, ChessGameUnit.Unit.KNIGHT);

        // Then: side & unit are expected enums
        assertEquals(ChessGameUnit.Side.WHITE, piece.getSide());
        assertEquals(ChessGameUnit.Unit.KNIGHT, piece.getUnit());
        assertEquals("Horse", piece.getUnit().label);
        assertEquals(3, piece.getUnit().relativeValue);
    }
}
