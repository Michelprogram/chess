package echec.pattern.chess.piece.pieces;

import echec.pattern.chess.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

//Bishop
//Déplacement diagonale sans limite
public class Fou extends Piece {
    public Fou(Boolean couleur, Integer[] position){
        super(couleur, position);
        this.character = 'F';
        this.zone.addAll(DEPLACEMENT_CROIX);
    }

    /*
    @Override
    public ArrayList<Integer[]> zoneDeDeplacement(){

        cleanZone();

        //Se positionne en haut à gauche puis lit en miroir les coordonnées.
        Integer[] position = { getOrdonnee() - 7, getAbscisse() - 7};

        int compteur = 14;

        for (int i = 0; i < 14; i++) {

            Integer[] tempo1 = new Integer[2], tempo2 = new Integer[2];

            tempo1[0] = position[0] + i ;
            tempo1[1] = position[1] + i;

            tempo2[0] = position[0] + i;

            if (i < 7){
                tempo2[1] = (position[1] + i) + compteur;
                compteur -=2;
            }
            else{
                tempo2[1] = (position[1] + i) - compteur;
                compteur +=2;
            }

            //Evite de jouer sur la même case
            if (!Arrays.equals(tempo1,getPositionNumber())){
                this.zone.add(Arrays.copyOf(tempo1, 2));
                this.zone.add(Arrays.copyOf(tempo2, 2));
            }
        }
        return filterDeplacement(this.zone);
    }*/
}
