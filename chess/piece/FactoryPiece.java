package chess.piece;

import chess.piece.pions.*;

public class FactoryPiece {

    public FactoryPiece(){}

    public Piece blanche( String nomPion){
        return switch (nomPion) {
            case ("Fou") -> new Fou();
            case ("Cavalier") -> new Cavalier();
            case ("Pion") -> new Pion();
            case ("Reine") -> new Reine();
            case ("Tour") -> new Tour();
            case ("Roi") -> new Roi();
            default -> null;
        };

    }

    /*
    static Piece noire( String nomPion){
        return new Fou(true);
    }
     */


}
