package chess.piece.pieces;

import chess.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

//Rook
//Déplacement horizontale, verticale sans limite
public class Tour extends Piece {

    public Tour(Boolean couleur, Integer[] position){
        super(couleur, position);
        this.character = 'T';
        zone.addAll(DEPLACEMENT_LIGNE);
    }

    @Override
    protected void cleanZone() {
        super.cleanZone();
    }

    /*  @Override

    public ArrayList<Integer[]> zoneDeDeplacement(){

        //cleanZone();

        //Se positionne tout à gauche par rapport aux coordonnées de la tour
        Integer[] position = { getOrdonnee() - 7, getAbscisse() - 7};

        for (int i = 0; i < 2; i++) {
            Integer[] tempo = Arrays.copyOf(position, 2);
            for (int j = 0; j < 16; j++) {

                tempo[0] = i == 0 ? getOrdonnee() : position[0] + j;
                tempo[1] = i == 0 ? position[1] + j : getAbscisse();

                //Evite de jouer sur la même case
                if (!Arrays.equals(tempo,getPositionNumber())){
                    this.zone.add(Arrays.copyOf(tempo, 2));
                }

            }
        }
        return null;
    }*/

}
