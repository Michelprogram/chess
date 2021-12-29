package chess.piece;

import java.util.Arrays;

public abstract class Piece {

    private char character;

    private Integer[] positionNumber;
    private String[] positionLetter;

    private Boolean couleur;
    private Boolean menace;


    public Piece(Boolean couleur,char namePiece, Integer[] positionNumber) {
        this.couleur = couleur;

        this.character = namePiece;

        this.positionNumber = positionNumber;

        this.menace = false;

        numberToLetter();

    }

    protected void numberToLetter(){

        //97 -> a dans la table ASCII
        final int asciiChar = 97 + this.positionNumber[1];

        String[] tab = {
                Integer.toString(8 - this.positionNumber[0]),
                String.valueOf( ((char) asciiChar))
        };

        setPositionLetter(tab);
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

        numberToLetter();
    }

    public String[] getPositionLetter() {
        return positionLetter;
    }

    public void setPositionLetter(String[] positionLetter) {
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
                " menacé " + (menace ? "oui": "non");

    }


}
