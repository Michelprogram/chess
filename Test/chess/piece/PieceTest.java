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
    public void deplacementRoi() throws Exception{
        ArrayList<Integer[]> attendu = new ArrayList<>(){
            {
                add(new Integer[]{0, 2});
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

    }

    @Test
    public void deplacementTour() throws Exception{

        ArrayList<Integer[]> attendu = new ArrayList<>(){
                {
                    //Axe horizontale
                    add(new Integer[]{2, 0});
                    add(new Integer[]{2, 2});
                    add(new Integer[]{2, 3});
                    add(new Integer[]{2, 4});
                    add(new Integer[]{2, 5});
                    add(new Integer[]{2, 6});
                    add(new Integer[]{2, 7});
                    add(new Integer[]{2, 8});

                    //Axe verticale
                    add(new Integer[]{0, 1});
                    add(new Integer[]{1, 1});
                    add(new Integer[]{3, 1});
                    add(new Integer[]{4, 1});
                    add(new Integer[]{5, 1});
                    add(new Integer[]{6, 1});
                    add(new Integer[]{7, 1});
                    add(new Integer[]{8, 1});

                }
        };

        Piece tour = factory.noire("Tour");
        tour.setPositionNumber(new Integer[]{ 2, 1});

        ArrayList<Integer[]> zone = tour.zoneDeDeplacement();

        for (int i = 0; i < attendu.size(); i++) {
            Integer[] tab1 = attendu.get(i);
            Integer[] tab2 = zone.get(i);

            assertArrayEquals(tab1, tab2);
        }

    }

    @Test
    public void deplacementFou() throws Exception{

        ArrayList<Integer[]> attendu = new ArrayList<>(){
            {
                add(new Integer[]{0,0});
                add(new Integer[]{0,6});

                add(new Integer[]{1,1});
                add(new Integer[]{1,5});

                add(new Integer[]{2,2});
                add(new Integer[]{2,4});

                add(new Integer[]{4,4});
                add(new Integer[]{4,2});

                add(new Integer[]{5,5});
                add(new Integer[]{5,1});

                add(new Integer[]{6,6});
                add(new Integer[]{6,0});

                add(new Integer[]{7,7});

                add(new Integer[]{8,8});
            }
        };

        Piece fou = factory.blanche("Fou");

        fou.setPositionNumber(new Integer[]{3 , 3});

        ArrayList<Integer[]> zone = fou.zoneDeDeplacement();

        for (int i = 0; i < attendu.size(); i++) {
            Integer[] tab1 = attendu.get(i);
            Integer[] tab2 = zone.get(i);

            assertArrayEquals(tab1, tab2);
        }

    }
}