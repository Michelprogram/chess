package chess.piece;

import chess.piece.pions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class FactoryPiece {

    private Boolean white, black;

    static ArrayList<Piece> whitePieces = new ArrayList<>();
    static ArrayList<Piece> blackPieces = new ArrayList<>();

    public FactoryPiece(){
        white = true;
        black = false;
    }

    public Piece blanche( String nomPion){

        Integer[] position = adjustPosition(white, nomPion);

        Piece p = switch (nomPion) {
            case ("Fou") -> new Fou(white, 'B', position);
            case ("Cavalier") -> new Cavalier(white, 'K',position);
            case ("Pion") -> new Pion(white, 'P', position);
            case ("Reine") -> new Reine(white, 'Q', position);
            case ("Tour") -> new Tour(white, 'R', position);
            case ("Roi") -> new Roi(white, 'K', position);
            default -> null;
        };

        whitePieces.add(p);

        return p;
    }

    private Integer[] adjustPosition(Boolean color, String piece){

        Integer[] position = new Integer[2];

        long occurrence = 0;

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
            case "Pion" -> {
                position[1] = (int) occurrence;
                position[0] = color ? 6 : 1;
            }
            case "Tour" -> {
                position[1] = (int) occurrence * 7;
                position[0] = color ? 7 : 0;
            }
            case "Cavalier" -> {
                position[1] = (int) occurrence == 0 ? 1 : 6;
                position[0] = color ? 7 : 0;
            }
            case "Fou" -> {
                position[1] = (int) occurrence == 0 ? 2 : 5;
                position[0] = color ? 7 : 0;
            }
            case "Roi" -> {
                position[1] = 3;
                position[0] = color ? 7 : 0;
            }
            case "Reine" -> {
                position[1] = 4;
                position[0] = color ? 7 : 0;
            }
        }

        System.out.println(Arrays.toString(position));

        return position;
    }

    private void addWhitePiece(){

    }

    /*
    static Piece noire( String nomPion){
        return new Fou(true);
    }
     */


}
