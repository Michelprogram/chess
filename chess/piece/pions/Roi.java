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
    protected ArrayList<Integer[]> zoneDeDeplacement(){

        ArrayList<Integer[]> zone = new ArrayList<>();

        Integer[] position = { getOrdonnee() - 1, getAbscisse() - 1};

        for (int i = 0; i < 3; i++) {
            Integer[] tempo = Arrays.copyOf(position, 2);

            for (int j = 0; j < 3; j++) {

                tempo[0] = position[0] + i;
                tempo[1] = position[1] + j;

                if (!Arrays.equals(tempo,getPositionNumber())){
                    zone.add(Arrays.copyOf(tempo, 2));
                }
            }
        }

        //Nettoie le tableau des zones en dehors du plateau
        return filterDeplacement(zone);

    }
}
