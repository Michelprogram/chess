package chess.piece;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    private final FactoryPiece factory = new FactoryPiece();
    private final Piece roiBlanc = factory.blanche("Roi");
    private final Piece roiNoir = factory.noire("Roi");


    @Test
    public void coordonnesLetter() throws Exception{
        String[] attendu = { "1" , "d"};
        Integer[] attendu2 = { 7, 3};
        assertArrayEquals(roiBlanc.getPositionLetter(), attendu);
        assertArrayEquals(roiBlanc.getPositionNumber(), attendu2);
    }

    @Test
    public void abscisseOrdonnee() throws Exception{
        System.out.println(roiBlanc);
        assertEquals(roiBlanc.getAbscisse(),3);
        assertEquals(roiBlanc.getOrdonnee(),7);
    }

    @Test
    public void deplaceMentRoi() throws Exception{
        ArrayList<Integer[]> attendu = new ArrayList<>(){
            {
                add(new Integer[]{0, 2});
                add(new Integer[]{0, 3});
                add(new Integer[]{0, 4});
                add(new Integer[]{1, 2});
                add(new Integer[]{1, 3});
                add(new Integer[]{1, 4});
            }
        };

        ArrayList<Integer[]> zone = roiNoir.zoneDeDeplacement();

        for (int i = 0; i < attendu.size(); i++) {
            Integer[] tab1 = attendu.get(i);
            Integer[] tab2 = zone.get(i);

            assertArrayEquals(tab1, tab2);
        }



        //Assert entre les 2 tab
    }

}