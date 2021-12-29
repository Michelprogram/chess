package chess.piece;

import chess.piece.pions.Reine;
import chess.piece.pions.Roi;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/*
@Test
public void InstanceOf() throws Exception{
        assertTrue(factoryPiece.blanche("Roi") instanceof Piece);
        assertFalse(factoryPiece.blanche("Roi") instanceof Reine);
        }

 */

class FactoryPieceTest{

    private FactoryPiece factoryPiece = new FactoryPiece();

    @Test
    public void InstanceOf() throws Exception{
        assertTrue(factoryPiece.blanche("Roi") instanceof Piece);
        assertFalse(factoryPiece.blanche("Roi") instanceof Reine);
    }

    @Test
    public void position() throws Exception{

        Integer[] position1 = new Integer[]{6, 0};
        Integer[] position2 = new Integer[]{6, 1};


        Piece p1 = factoryPiece.blanche("Pion");
        Piece p2 = factoryPiece.blanche("Pion");

        assertArrayEquals(p1.getPositionNumber(), position1);
        assertArrayEquals(p2.getPositionNumber(), position2);


    }

    @Test
    public void pieceBlanche() throws Exception{

        Piece p1 = factoryPiece.blanche("Pion");
        System.out.println(p1);
    }

}