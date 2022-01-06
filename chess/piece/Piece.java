package chess.piece;

import Chess2.Couleur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Piece {
    //constantes déplacement (en partant de la case en haut à gauche -> (0;0))
    protected ArrayList<Integer[]> DEPLACEMENT_LIGNE = new ArrayList(){{
        for(int i=-1;i>=-7;i--){add(new Integer[]{i,0});}
        for(int i=1;i<=7;i++){add(new Integer[]{0,i});}
        for(int i=1;i<=7;i++){add(new Integer[]{i,0});}
        for(int i=-1;i>=-7;i--){add(new Integer[]{0,i});}
    }};
    protected ArrayList<Integer[]> DEPLACEMENT_CROIX = new ArrayList(){{
        for(int i=-1;i>=-7;i--){add(new Integer[]{i,Math.abs(i)});}//ex : (-1;1)
        for(int i=1;i<=7;i++){add(new Integer[]{i,i});}
        for(int i=-1;i>=-7;i--){add(new Integer[]{Math.abs(i),i});}//ex : (1
        for(int i=-1;i>=-7;i--){add(new Integer[]{i,i});}
    }};
    //------------------------------------------------------------------------------
    protected char character;
    protected Integer[] positionNumber;
    protected String positionLetter;
    protected Boolean couleur;
    protected String couleurCharacter;
    protected Boolean menace;//maybe
    protected ArrayList<Integer[]> zone;


    public Piece(Boolean couleur,Integer[] positionNumber) {
        this.couleur = couleur;
        if(couleur) this.couleurCharacter = Couleur.ANSI_WHITE_BOLD_BRIGHT.getValue();
        else if(!couleur) this.couleurCharacter = Couleur.ANSI_BLACK.getValue();

        this.positionNumber = positionNumber;
        this.menace = false;
        this.zone = new ArrayList<>();

        numberToLetter();
    }

    //Converti les coordonnées en lettre
    protected void numberToLetter(){

        //97 -> a dans la table ASCII
        final int asciiChar = 97 + this.positionNumber[1];

        String tab = Integer.toString(8 - this.positionNumber[0]) + String.valueOf( ((char) asciiChar));

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

    //Met à jour les coordonnées de la pièces lors de son déplacement
    public void setPositionNumber(Integer[] positionNumber) {
        this.positionNumber = positionNumber;

        numberToLetter();
    }

    public String getPositionLetter() {
        return positionLetter;
    }

    public void setPositionLetter(String positionLetter) {
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

    //-------------------------------------------------------------------------------------------
    //Vide le tableau de zone de déplacement et le réinitialise
    protected void cleanZone(){
        this.zone.clear();
    }
    //Méthode qui se fait override par les classes enfants
    public ArrayList<Integer[]> zoneDeDeplacement(){
        //cleanZone();
        //copie de la zone de déplacement
        ArrayList<Integer[]> zoneDeplacementCopie = new ArrayList<>();
        for(Integer[] coordonne : zone){
            zoneDeplacementCopie.add(coordonne);
        }

        //on récupère la position de la pièce par rapport à la case (0;0)
        int deltaX = this.getAbscisse();
        int deltaY = this.getOrdonnee();

        //on modifie la zone de déplacement en conséquence
        for(Integer[] coordonne : zoneDeplacementCopie){
            coordonne[0]+=deltaY;
            coordonne[1]+=deltaX;
        }
        return filterDeplacement(zoneDeplacementCopie);
    }

    //Après avoir trouvé les zones de déplacement on nettoie toutes les cases qui sont en dehors du plateau
    protected ArrayList<Integer[]> filterDeplacement(ArrayList<Integer[]> zone){
        return (ArrayList<Integer[]>) zone.stream()
                .filter( el -> (el[0] >= 0 && el[0] < 8) && (el[1] >= 0 && el[1] < 8) )
                .collect(Collectors.toList());
    }

    //Permet d'avoir des informations supplémentaires sur une pièce
    @Override
    public String toString() {
        return this.couleurCharacter + this.character;
    }

}
