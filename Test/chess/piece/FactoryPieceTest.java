package chess.piece;

import chess.piece.pions.Reine;
import chess.piece.pions.Roi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryPieceTest{

    private FactoryPiece factoryPiece = new FactoryPiece();

    @Test
    public void InstanceOf() throws Exception{
        assertTrue(factoryPiece.blanche("Roi") instanceof Piece);
        assertFalse(factoryPiece.blanche("Roi") instanceof Reine);
    }

}