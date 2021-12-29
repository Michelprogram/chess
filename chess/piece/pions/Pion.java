package chess.piece.pions;

import chess.piece.Piece;

//Pawn
//Déplacement droit 2 au premier tour puis 1, mange qu'en diagonale
public class Pion extends Piece {

    private boolean premierTour;

    public Pion(Boolean couleur, char namePiece, Integer[] position) {
        super(couleur, namePiece, position);
    }
}
