package chess.piece;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    private final FactoryPiece factory = new FactoryPiece();
    private final Piece roi = factory.blanche("Roi");

    @Test
    public void coordonnesLetter() throws Exception{
        String[] attendu = { "1" , "d"};
        Integer[] attendu2 = { 7, 3};
        assertArrayEquals(roi.getPositionLetter(), attendu);
        assertArrayEquals(roi.getPositionNumber(), attendu2);
    }
}