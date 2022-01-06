package chess.piece.pieces;

import chess.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

//Knight
//Déplacement en L
public class Cavalier extends Piece {

    public Cavalier(Boolean couleur, Integer[] position) {
        super(couleur, position);
        this.character = 'C';
    }

    //Cherche les zones possible
    @Override
    public ArrayList<Integer[]> zoneDeDeplacement(){
        cleanZone();

        for (int i = 0; i < 4; i++) {
            Integer[] tempo = new Integer[2];
            Integer[] tempo2 = new Integer[2];

            //Top
            //Right
            //Bottom
            //Left
            switch (i) {
                case (0):
                    tempo[0] = getOrdonnee() - 2;
                    tempo[1] = getAbscisse() - 1;
                    tempo2[0] = getOrdonnee() - 2;
                    tempo2[1] = getAbscisse() + 1;
                    break;
                case (1):
                    tempo[0] = getOrdonnee() - 1;
                    tempo[1] = getAbscisse() + 2;
                    tempo2[0] = getOrdonnee() + 2;
                    tempo2[1] = getAbscisse() + 2;
                    break;
                case (2):
                    tempo[0] = getOrdonnee() + 2;
                    tempo[1] = getAbscisse() + 1;
                    tempo2[0] = getOrdonnee() + 2;
                    tempo2[1] = getAbscisse() - 1;
                    break;
                case (3):
                    tempo[0] = getOrdonnee() + 1;
                    tempo[1] = getAbscisse() - 2;
                    tempo2[0] = getOrdonnee() - 1;
                    tempo2[1] = getAbscisse() - 2;
                    break;
            }

            this.zone.add(Arrays.copyOf(tempo, 2));
            this.zone.add(Arrays.copyOf(tempo2, 2));
        }

        return filterDeplacement(this.zone);
    }
}