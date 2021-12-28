package chess.piece;

import java.util.Arrays;

public abstract class Piece {

    private char character;

    private Integer[] positionNumber;
    private Integer[] positionLetter;

    private Boolean couleur;
    private Boolean menace;

    /*
    public Piece(Boolean couleur) {
        this.couleur = couleur;
    }
     */

    public Piece(){

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
        return "Piece{" +
                "character=" + character +
                ", positionNumber=" + Arrays.toString(positionNumber) +
                ", positionLetter=" + Arrays.toString(positionLetter) +
                ", couleur=" + couleur +
                ", menace=" + menace +
                '}';
    }


}
