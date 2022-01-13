package echec.pattern.chess.piece.pieces;

import echec.pattern.chess.piece.Piece;

//Queen
//Déplacement partout sans limite
public class Reine extends Piece {
    public Reine(Boolean couleur,Integer[] position){
        super(couleur, position);
        this.character = 'Q';
        this.zone.addAll(DEPLACEMENT_CROIX);
        this.zone.addAll(DEPLACEMENT_LIGNE);
    }

}
