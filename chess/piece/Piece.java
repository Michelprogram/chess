package chess.piece;

import Chess2.Couleur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Piece {
    //constantes déplacement (en partant de la case en haut à gauche -> (0;0))
    protected ArrayList<ArrayList<Integer[]>> DEPLACEMENT_LIGNE = new ArrayList(){{
        add(new ArrayList<Integer[]>(){{for(int i=-1;i>=-7;i--){add(new Integer[]{i,0});}}});
        add(new ArrayList<Integer[]>(){{for(int i=1;i<=7;i++){add(new Integer[]{0,i});}}});
        add(new ArrayList<Integer[]>(){{for(int i=1;i<=7;i++){add(new Integer[]{i,0});}}});
        add(new ArrayList<Integer[]>(){{for(int i=-1;i>=-7;i--){add(new Integer[]{0,i});}}});
    }};
    protected ArrayList<ArrayList<Integer[]>> DEPLACEMENT_CROIX = new ArrayList(){{
        add(new ArrayList<Integer[]>(){{for(int i=-1;i>=-7;i--){add(new Integer[]{i,Math.abs(i)});}}});//ex : (-1;1)
        add(new ArrayList<Integer[]>(){{for(int i=1;i<=7;i++){add(new Integer[]{i,i});}}});
        add(new ArrayList<Integer[]>(){{for(int i=-1;i>=-7;i--){add(new Integer[]{Math.abs(i),i});}}});//ex : (1;-1)
        add(new ArrayList<Integer[]>(){{for(int i=-1;i>=-7;i--){add(new Integer[]{i,i});}}});
    }};
    //------------------------------------------------------------------------------
    protected char character;
    protected Integer[] positionNumber;
    protected String positionLetter;
    protected Boolean couleur;
    protected String couleurCharacter;
    protected Boolean menace;//maybe
    protected ArrayList<ArrayList<Integer[]>> zone;//zone de déplacement de la piece (sans prendre en compte la position des autres pièces)
    protected ArrayList<ArrayList<Integer[]>> zoneRecalculee;//zone de déplacement de la piece (tenant compte de la position des autres pièces)


    public Piece(Boolean couleur,Integer[] positionNumber) {
        this.couleur = couleur;
        if(couleur) this.couleurCharacter = Couleur.ANSI_WHITE_BOLD_BRIGHT.getValue();
        else if(!couleur) this.couleurCharacter = Couleur.ANSI_BLACK.getValue();

        this.positionNumber = positionNumber;
        this.menace = false;
        this.zone = new ArrayList<>();
        this.zoneRecalculee = new ArrayList<>();

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

    public Boolean isMenace() {
        return menace;
    }

    public void setMenace(Boolean menace) {
        this.menace = menace;
    }

    //-------------------------------------------------------------------------------------------
    //Méthode qui se fait override par la classe Pion, calcule la zone de déplacement
    public ArrayList<ArrayList<Integer[]>> zoneDeDeplacement(){
        //on récupère la position de la pièce par rapport à la case (0;0)
        int deltaX = this.getAbscisse();
        int deltaY = this.getOrdonnee();

        //on modifie la zone de déplacement en conséquence
        ArrayList<ArrayList<Integer[]>> zoneDeplacementCopie = new ArrayList<>();//copie de la zone de déplacement
        for(ArrayList<Integer[]> ligne : zone){
            ArrayList<Integer[]> ligneCopie = new ArrayList<>();
            for(Integer[] coordonne : ligne){
                int nouvelAbcisse = coordonne[1]+deltaX;
                int nouvelleOrdonnee = coordonne[0]+deltaY;
                if((nouvelAbcisse >= 0 && nouvelAbcisse < 8) && (nouvelleOrdonnee >= 0 && nouvelleOrdonnee < 8))//filtrage de la zone
                    ligneCopie.add(new Integer[]{nouvelleOrdonnee,nouvelAbcisse});
            }
            if(!ligneCopie.isEmpty())
                zoneDeplacementCopie.add(ligneCopie);
        }
        return zoneDeplacementCopie;
    }

    //Vide le tableau de zone de déplacement et le réinitialise
    public void cleanZone(){
        this.zone.clear();
    }

    //Après avoir trouvé les zones de déplacement on nettoie toutes les cases qui sont en dehors du plateau
    protected ArrayList<Integer[]> filterDeplacement(ArrayList<Integer[]> zone){
        return (ArrayList<Integer[]>) zone.stream()
                .filter( el -> (el[0] >= 0 && el[0] < 8) && (el[1] >= 0 && el[1] < 8) )
                .collect(Collectors.toList());
    }

    public ArrayList<ArrayList<Integer[]>> getZoneRecalculee() {
        return zoneRecalculee;
    }

    public void setZoneRecalculee(ArrayList<ArrayList<Integer[]>> zoneRecalculee) {
        this.zoneRecalculee = zoneRecalculee;
    }

    //Permet d'avoir des informations supplémentaires sur une pièce
    @Override
    public String toString() {
        return this.couleurCharacter + this.character;
    }

}
