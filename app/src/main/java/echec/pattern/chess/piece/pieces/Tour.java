package echec.pattern.chess.piece.pieces;

import echec.pattern.chess.piece.Piece;

//Rook
//Déplacement horizontale, verticale sans limite
public class Tour extends Piece {

    public Tour(Boolean couleur, Integer[] position){
        super(couleur, position);
        this.character = 'T';
        zone.addAll(DEPLACEMENT_LIGNE);
    }

}
