package chess.piece.pions;

import chess.piece.Piece;

//Bishop
//Déplacement diagonale sans limite
public class Fou extends Piece {
    public Fou(Boolean couleur, char namePiece, Integer[] position){
        super(couleur, namePiece, position);
    }
}
