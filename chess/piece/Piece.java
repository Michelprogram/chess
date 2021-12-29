package chess.piece;

import java.util.Arrays;

public abstract class Piece {

    private char character;

    private Integer[] positionNumber;
    private Integer[] positionLetter;

    private Boolean couleur;
    private Boolean menace;


    public Piece(Boolean couleur,char namePiece, Integer[] positionNumber) {
        this.couleur = couleur;

        this.character = namePiece;

        this.positionNumber = positionNumber;

    }

    Integer[] numberToLetter(Integer[] positionNumber){

        return null;
    }

    Integer[] letterToNumber(Integer[] positionLetter){
        return null;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public Integer[] getPositionNumber() {
        return positionNumber;
    }

    public void setPositionNumber(Integer[] positionNumber) {
        this.positionNumber = positionNumber;
    }

    public Integer[] getPositionLetter() {
        return positionLetter;
    }

    public void setPositionLetter(Integer[] positionLetter) {
        this.positionLetter = positionLetter;
    }

    public Boolean getCouleur() {
        return couleur;
    }

    public void setCouleur(Boolean couleur) {
        this.couleur = couleur;
    }

    public Boolean getMenace() {
        return menace;
    }

    public void setMenace(Boolean menace) {
        this.menace = menace;
    }

    @Override
    public String toString() {
        return "Je suis un(e) " + this.getClass().getSimpleName() +
                " symbolisé par " + character +
                " à la position " + Arrays.toString(positionNumber) +
                " et aussi " + Arrays.toString(positionLetter) +
                " de couleur " + (couleur ? "blanche" : "noire") +
                " menacé " ;

    }


}
