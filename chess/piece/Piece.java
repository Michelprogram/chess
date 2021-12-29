package chess.piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

//TODO mettre en attriut zone
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

    public Integer getAbscisse(){
        return this.getPositionNumber()[1];
    }

    public Integer getOrdonnee(){
        return this.getPositionNumber()[0];
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

    protected ArrayList<Integer[]> zoneDeDeplacement(){
        return null;
    }

    //Après avoir trouvé les zones de déplacement ont nettoie toutes les cases qui sont en dehors du plateau
    protected ArrayList<Integer[]> filterDeplacement(ArrayList<Integer[]> zone){
        return (ArrayList<Integer[]>) zone.stream()
                .filter( el -> (el[0] >= 0 && el[0] <= 8) && (el[1] >= 0 && el[1] <= 8) )
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Je suis un(e) " + this.getClass().getSimpleName() +
                " symbolisé par " + character +
                " à la position " + Arrays.toString(positionNumber) +
                " et aussi " + Arrays.toString(positionLetter) +
                " d'abscisse " + getAbscisse() +
                " et d'ordonnée " + getOrdonnee()+
                " de couleur " + (couleur ? "blanche" : "noire") +
                " menacé " + (menace ? "oui": "non");

    }

    public void stringTest(){

        ArrayList<Integer[]> test = zoneDeDeplacement();

         test.forEach(el -> System.out.println(Arrays.toString(el)));
    }


}
