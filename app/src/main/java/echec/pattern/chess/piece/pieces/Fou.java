package echec.pattern.chess.piece.pieces;

import echec.pattern.chess.piece.Piece;

//Bishop
//Déplacement diagonale sans limite
public class Fou extends Piece {
    public Fou(Boolean couleur, Integer[] position){
        super(couleur, position);
        this.character = 'F';
        this.zone.addAll(DEPLACEMENT_CROIX);
    }

}
