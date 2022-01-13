package echec.pattern.chess.piece.pieces;

import echec.pattern.chess.piece.Piece;

import java.util.ArrayList;

//Knight
//Déplacement en L
public class Cavalier extends Piece {

    public Cavalier(Boolean couleur, Integer[] position) {
        super(couleur, position);
        this.character = 'C';
        //déplacement en L à partir de la case (0;0)
        ArrayList<ArrayList<Integer[]>> DEPLACEMENT_L = new ArrayList() {{
            add(new ArrayList<Integer[]>() {{
                add(new Integer[]{-2, 1});
            }});
            add(new ArrayList<Integer[]>() {{
                add(new Integer[]{-1, 2});
            }});
            add(new ArrayList<Integer[]>() {{
                add(new Integer[]{1, 2});
            }});
            add(new ArrayList<Integer[]>() {{
                add(new Integer[]{2, 1});
            }});
            add(new ArrayList<Integer[]>() {{
                add(new Integer[]{2, -1});
            }});
            add(new ArrayList<Integer[]>() {{
                add(new Integer[]{1, -2});
            }});
            add(new ArrayList<Integer[]>() {{
                add(new Integer[]{-1, -2});
            }});
            add(new ArrayList<Integer[]>() {{
                add(new Integer[]{-2, -1});
            }});
        }};
        zone.addAll(DEPLACEMENT_L);
    }

}
