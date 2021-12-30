package chess.piece.pions;

import chess.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

//Pawn
//Déplacement droit 2 au premier tour puis 1, mange qu'en diagonale
public class Pion extends Piece {

    private boolean premierTour;

    public Pion(Boolean couleur, char namePiece, Integer[] position) {
        super(couleur, namePiece, position);

        premierTour = true;
    }

    @Override
    public ArrayList<Integer[]> zoneDeDeplacement() {
        cleanZone();

        if(premierTour){
            for (int i = 0; i < 2; i++) {
                Integer[] tempo = new Integer[2];

                tempo[0] = getCouleur() ? getOrdonnee() - i: getOrdonnee() + i;
                tempo[1] = getAbscisse();

                this.zone.add(Arrays.copyOf(tempo, 2));
            }

            premierTour = false;
        }
        //Si un pion adverse en diagonale peut le manger
        else{
            this.zone.add(new Integer[]{
                    getCouleur() ? getOrdonnee() - 1 : getOrdonnee() + 1,
                    getAbscisse()
            });
        }

        return filterDeplacement(this.zone);
    }
}
