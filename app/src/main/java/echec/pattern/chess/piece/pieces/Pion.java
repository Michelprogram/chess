package echec.pattern.chess.piece.pieces;

import echec.pattern.chess.piece.Piece;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//Pawn
//Déplacement droit 2 au premier tour puis 1, mange qu'en diagonale
public class Pion extends Piece {

    //Le pion change de possibilité de déplacement au second tour
    private boolean premierTour;
    private int direction;

    public Pion(Boolean couleur, Integer[] position) {
        super(couleur, position);
        this.character = 'P';
        premierTour = true;
        this.direction = couleur ? -1 : 1;//-1=vers le haut, 1=vers le bas
    }

    public int getDirection() {
        return direction;
    }

    public boolean isPremierTour(){
        return this.premierTour;
    }

    public void setPremierTour(boolean premierTour){
        this.premierTour = premierTour;
    }

    @Override
    public ArrayList<ArrayList<Integer[]>> zoneDeDeplacement() {
        cleanZone();

        //Premier tour peut aller de 2 cases en avant
        if(premierTour){
            premierTour = false;
            ArrayList<Integer[]> tempList = new ArrayList();
            for (int i = 1; i < 3; i++) {
                Integer[] tempo = new Integer[2];

                tempo[0] = getOrdonnee()+(i*this.direction);
                tempo[1] = getAbscisse();
                tempList.add(Arrays.copyOf(tempo, 2));
            }
            this.zone.add(tempList);
        }
        else
        {//Second tour peut se déplacer d'une case en avant
            this.zone.add(new ArrayList(){{
                add(new Integer[]{
                        getCouleur() ? getOrdonnee() - 1 : getOrdonnee() + 1,
                        getAbscisse()
                });
            }});
        }

        //filtrage de la zone
        ArrayList<ArrayList<Integer[]>> zoneDeplacementCopie = new ArrayList<>();//copie de la zone de déplacement
        for(ArrayList<Integer[]> ligne : zone){
            ArrayList<Integer[]> ligneCopie = new ArrayList<>();
            for(Integer[] coordonne : ligne){
                int nouvelAbcisse = coordonne[1];
                int nouvelleOrdonnee = coordonne[0];
                if((nouvelAbcisse >= 0 && nouvelAbcisse < 8) && (nouvelleOrdonnee >= 0 && nouvelleOrdonnee < 8))//filtrage de la zone
                    ligneCopie.add(new Integer[]{nouvelleOrdonnee,nouvelAbcisse});
            }
            zoneDeplacementCopie.add(ligneCopie);
        }
        return zoneDeplacementCopie;
    }
}
