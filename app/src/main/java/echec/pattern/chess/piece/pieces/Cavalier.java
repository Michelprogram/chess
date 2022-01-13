package echec.pattern.chess.piece.pieces;

import echec.pattern.chess.piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

//Knight
//Déplacement en L
public class Cavalier extends Piece {
    //déplacement en L à partir de la case (0;0)
    private ArrayList<ArrayList<Integer[]>> DEPLACEMENT_L = new ArrayList(){{
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{-2,1});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{-1,2});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{1,2});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{2,1});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{2,-1});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{1,-2});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{-1,-2});
        }});
        add(new ArrayList<Integer[]>(){{
            add(new Integer[]{-2,-1});
        }});
    }};

    public Cavalier(Boolean couleur, Integer[] position) {
        super(couleur, position);
        this.character = 'C';
        zone.addAll(DEPLACEMENT_L);
    }

}
