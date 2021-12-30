package chess.piece.pions;

import chess.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

//Rook
//Déplacement horizontale, verticale sans limite
public class Tour extends Piece {

    public Tour(Boolean couleur, char charactere, Integer[] position){
        super(couleur, charactere, position);

    }

    @Override
    protected ArrayList<Integer[]> zoneDeDeplacement(){

        cleanZone();

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

        //Nettoie le tableau des zones en dehors du plateau
        return filterDeplacement(this.zone);

    }

}
