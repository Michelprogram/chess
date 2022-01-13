package echec.pattern.chess.piece;

import echec.pattern.chess.piece.pieces.*;
import java.util.ArrayList;

//Fabrique des pièces sur le plateau
public class FactoryPiece {

    private final Boolean white;
    private final Boolean black;

    /*
        Liste de pion noir et blanc pour savoir à quel endroit les positionnés.
     */

    static ArrayList<Piece> whitePieces = new ArrayList<>();
    static ArrayList<Piece> blackPieces = new ArrayList<>();

    public FactoryPiece(){
        white = true;
        black = false;
    }

    //Factory pour les pièces blanches
    public Piece blanche( String nomPion){

        Integer[] position = adjustPosition(white, nomPion);

        Piece p;
        switch (nomPion) {
            case ("Fou"):
                p = new Fou(white,position);
                break;
            case ("Cavalier"):
                p = new Cavalier(white,position);
                break;
            case ("Pion"):
                p = new Pion(white,position);
                break;
            case ("Reine"):
                p = new Reine(white,position);
                break;
            case ("Tour"):
                p = new Tour(white,position);
                break;
            case ("Roi"):
                p = new Roi(white, position);
                break;
            default:
                p = null;
                break;
        }

        whitePieces.add(p);

        return p;
    }

    //Factory pour les pièces noires
    public Piece noire( String nomPion){
        Integer[] position = adjustPosition(black, nomPion);

        Piece p;
        switch (nomPion) {
            case ("Fou"):
                p = new Fou(black, position);
                break;
            case ("Cavalier"):
                p = new Cavalier(black,position);
                break;
            case ("Pion"):
                p = new Pion(black,position);
                break;
            case ("Reine"):
                p = new Reine(black,position);
                break;
            case ("Tour"):
                p = new Tour(black, position);
                break;
            case ("Roi"):
                p = new Roi(black,position);
                break;
            default:
                p = null;
                break;
        }

        blackPieces.add(p);

        return p;

    }

    //Ajuste la position du futur en fonction des autres précédemment instancié
    private Integer[] adjustPosition(Boolean color, String piece){

        Integer[] position = new Integer[2];

        long occurrence;

        if(color) {
            occurrence = whitePieces.stream()
                    .filter(el -> el.getClass().getSimpleName().equals(piece))
                    .count();
        }
        else {
            occurrence = blackPieces.stream()
                    .filter(el -> el.getClass().getSimpleName().equals(piece))
                    .count();
        }

        switch (piece) {
            case "Pion":
                position[1] = (int) occurrence;
                position[0] = color ? 6 : 1;
                break;
            case "Tour":
                position[1] = (int) occurrence * 7;
                position[0] = color ? 7 : 0;
                break;
            case "Cavalier":
                position[1] = (int) occurrence == 0 ? 1 : 6;
                position[0] = color ? 7 : 0;
                break;
            case "Fou":
                position[1] = (int) occurrence == 0 ? 2 : 5;
                position[0] = color ? 7 : 0;
                break;
            case "Roi":
                position[1] = 3;
                position[0] = color ? 7 : 0;
                break;
            case "Reine":
                position[1] = 4;
                position[0] = color ? 7 : 0;
                break;
        }

        return position;
    }

}
