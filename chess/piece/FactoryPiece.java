package chess.piece;

import chess.piece.pion.Fou;

public class FactoryPiece {

    static Piece blanche( String nomPion){

        switch (nomPion){

            case ("Fou"):
                break;

            case ("Cavalier"):
                break;

            case("Pion"):
                break;

            case("Reine"):
                break;

            case("Tour"):
                break;

            case ("Roi"):
                break;
        }

    }

    static Piece noire( String nomPion){
        return new Fou(true);
    }


}
