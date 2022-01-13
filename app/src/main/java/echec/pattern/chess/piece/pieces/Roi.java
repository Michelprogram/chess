package echec.pattern.chess.piece.pieces;

import echec.pattern.chess.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

//King
//Déplacement partout 1 seul case autour de lui
public class Roi extends Piece {
    private ArrayList<ArrayList<Integer[]>> DEPLACEMENT_ROI = new ArrayList(){{
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{-1,0});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{-1,1});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{0,1});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{1,1});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{1,0});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{1,-1});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{0,-1});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{-1,-1});
        }});
    }};

    public Roi(Boolean couleur, Integer[] position){
        super(couleur, position);
        this.character = 'R';
        this.zone.addAll(DEPLACEMENT_ROI);
    }
}
