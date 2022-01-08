package chess.piece.pieces;

import chess.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

//King
//Déplacement partout 1 seul case autour de lui
public class Roi extends Piece {
    private ArrayList<ArrayList<Integer[]>> DEPLACEMENT_ROI = new ArrayList(){{
        add(new ArrayList<Integer[]>(){{add(new Integer[]{-1,0});}}); add(new ArrayList<Integer[]>(){{add(new Integer[]{-1,1});}});
        add(new ArrayList<Integer[]>(){{add(new Integer[]{0,1});}}); add(new ArrayList<Integer[]>(){{add(new Integer[]{1,1});}});
        add(new ArrayList<Integer[]>(){{add(new Integer[]{1,0});}}); add(new ArrayList<Integer[]>(){{add(new Integer[]{1,-1});}});
        add(new ArrayList<Integer[]>(){{add(new Integer[]{0,-1});}}); add(new ArrayList<Integer[]>(){{add(new Integer[]{-1,-1});}});
    }};

    public Roi(Boolean couleur, Integer[] position){
        super(couleur, position);
        this.character = 'R';
        this.zone.addAll(DEPLACEMENT_ROI);
    }
/*
    @Override
    public ArrayList<Integer[]> zoneDeDeplacement(){

        cleanZone();

        //Se positionne en haut à gauche par rapport aux coordonnées du roi,
        // puis lit sur 3 lignes les coordonnées possible
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
        return filterDeplacement(this.zone);
    }*/
}
