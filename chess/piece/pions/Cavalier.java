package chess.piece.pions;

import chess.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

//Knight
//Déplacement en L
public class Cavalier extends Piece {

    public Cavalier(Boolean couleur, char namePiece, Integer[] position) {
        super(couleur, namePiece, position);
    }

    @Override
    protected ArrayList<Integer[]> zoneDeDeplacement(){
        cleanZone();

        for (int i = 0; i < 4; i++) {
            Integer[] tempo = new Integer[2];
            Integer[] tempo2 = new Integer[2];

            switch (i) {
                //Top
                case (0) -> {

                    tempo[0] = getOrdonnee() - 2;
                    tempo[1] = getAbscisse() - 1;

                    tempo2[0] = getOrdonnee() - 2;
                    tempo2[1] = getAbscisse() + 1;
                }

                //Right
                case (1) -> {
                    tempo[0] = getOrdonnee() - 1;
                    tempo[1] = getAbscisse() + 2;

                    tempo2[0] = getOrdonnee() + 2;
                    tempo2[1] = getAbscisse() + 2;
                }

                //Bottom
                case(2) ->{
                    tempo[0] = getOrdonnee() + 2;
                    tempo[1] = getAbscisse() + 1;

                    tempo2[0] = getOrdonnee() + 2;
                    tempo2[1] = getAbscisse() - 1;
                }

                //Left
                case (3) ->{
                    tempo[0] = getOrdonnee() + 1;
                    tempo[1] = getAbscisse() - 2;

                    tempo2[0] = getOrdonnee() - 1;
                    tempo2[1] = getAbscisse() - 2;
                }
            }

            this.zone.add(Arrays.copyOf(tempo, 2));
            this.zone.add(Arrays.copyOf(tempo2, 2));
        }

        return filterDeplacement(this.zone);
    }
}
