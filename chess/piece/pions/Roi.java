package chess.piece.pions;

import chess.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

//King
//Déplacement partout 1 seul case autour de lui
public class Roi extends Piece {
    public Roi(Boolean couleur, char charactere, Integer[] position){
        super(couleur, charactere, position);
    }

    @Override
    public ArrayList<Integer[]> zoneDeDeplacement(){

        cleanZone();

        Integer[] position = { getOrdonnee() - 1, getAbscisse() - 1};

        for (int i = 0; i < 3; i++) {
            Integer[] tempo = Arrays.copyOf(position, 2);

            for (int j = 0; j < 3; j++) {

                tempo[0] = position[0] + i;
                tempo[1] = position[1] + j;

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
