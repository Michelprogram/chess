package chess.piece;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//Les test sont réalisé comme si la pièce en questions était toute seul sur le plateau
class PieceTest {

    private final FactoryPiece factory = new FactoryPiece();
    private final Piece roiBlanc = factory.blanche("Roi");
    private final Piece roiNoir = factory.noire("Roi");

    public void AssertBetweenArray(ArrayList<Integer[]> tab1, ArrayList<Integer[]> tab2){
        for (int i = 0; i < tab1.size(); i++) {
            Integer[] element1 = tab1.get(i);
            Integer[] element2 = tab2.get(i);

            assertArrayEquals(element1, element2);
        }
    }

    //Conversion des coordonnées cohérentes
    @Test
    public void coordonnesLetter() throws Exception{
        String attendu = "1d";
        Integer[] attendu2 = { 7, 3};

        assertEquals(roiBlanc.getPositionLetter(), attendu);
        assertArrayEquals(roiBlanc.getPositionNumber(), attendu2);
    }

    @Test
    public void abscisseOrdonnee() throws Exception{
        System.out.println(roiBlanc);
        assertEquals(roiBlanc.getAbscisse(),3);
        assertEquals(roiBlanc.getOrdonnee(),7);
    }

    //Déplacement du roi tout autour de lui, range 1 case
    @Test
    public void deplacementRoi() throws Exception{
        ArrayList<ArrayList<Integer[]>> attendu = new ArrayList(){{
            add(new ArrayList<Integer[]>(){{add(new Integer[]{0,4});}});
            add(new ArrayList<Integer[]>(){{add(new Integer[]{1,4});}});
            add(new ArrayList<Integer[]>(){{add(new Integer[]{1,3});}});
            add(new ArrayList<Integer[]>(){{add(new Integer[]{1,2});}});
            add(new ArrayList<Integer[]>(){{add(new Integer[]{0,2});}});
        }};

        ArrayList<ArrayList<Integer[]>> zone = roiNoir.zoneDeDeplacement();
        for(ArrayList<Integer[]> ligne : zone){
            for(Integer[] c : ligne){
                System.out.println(Arrays.toString(c));
            }
        }

        assertArrayEquals(attendu.toArray(), zone.toArray());

    }
/*
    //Déplacement de la tour horizontale et verticale aussi bien devant que derrière
    @Test
    public void deplacementTour() throws Exception{

        ArrayList<Integer[]> attendu = new ArrayList<Integer[]>(){
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

        AssertBetweenArray(attendu, zone);

    }

    //Déplacement du fou en diagonale aussi bien devant que derrière
    @Test
    public void deplacementFou() throws Exception{

        ArrayList<Integer[]> attendu = new ArrayList<Integer[]>(){
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

        AssertBetweenArray(attendu, zone);

    }

    //Déplacement du pion sur 2 cases maximum
    //Test échoue quand on les exécute tous
    @Test
    public void deplacementPion() throws Exception{

        ArrayList<Integer[]> attendu = new ArrayList<Integer[]>(){
            {
                add(new Integer[]{6,0});
                add(new Integer[]{5,0});
            }
        };

        Piece pion = factory.blanche("Pion");

        ArrayList<Integer[]> zone = pion.zoneDeDeplacement();

        AssertBetweenArray(attendu, zone);

    }

    //Déplacement du pion après son premier tour donc passe à une case de déplacement et non 2
    @Test
    public void deplacementPion2() throws Exception{

        ArrayList<Integer[]> attendu = new ArrayList<Integer[]>(){
            {
                add(new Integer[]{5,0});
            }
        };

        Piece pion = factory.blanche("Pion");

        //Joue son premier tour
        pion.zoneDeDeplacement();

        ArrayList<Integer[]> zone = pion.zoneDeDeplacement();

        AssertBetweenArray(attendu, zone);

    }

    //Déplacement du cavalier en L aussi bien en avant qu'en arrière
    @Test
    public void deplacementCavalier() throws Exception{

        ArrayList<Integer[]> attendu = new ArrayList<Integer[]>(){
            {
                add(new Integer[]{5,0});
                add(new Integer[]{5,2});
                add(new Integer[]{6,3});
            }
        };

        Piece cavalier = factory.blanche("Cavalier");

        ArrayList<Integer[]> zone = cavalier.zoneDeDeplacement();

        AssertBetweenArray(attendu, zone);

    }

    //Déplacement de la reine, qui combine les déplacements du cavalier et du fou
    @Test
    public void deplacementReine() throws Exception{

        ArrayList<Integer[]> attendu = new ArrayList<Integer[]>(){
            {
                add(new Integer[]{3,0});
                add(new Integer[]{3,8});
                add(new Integer[]{4,1});
                add(new Integer[]{4, 7});
                add(new Integer[]{5, 2});
                add(new Integer[]{5, 6});
                add(new Integer[]{6, 3});
                add(new Integer[]{6, 5});
                add(new Integer[]{8, 5});
                add(new Integer[]{8, 3});
                add(new Integer[]{7, 0});
                add(new Integer[]{7, 1});
                add(new Integer[]{7, 2});
                add(new Integer[]{7, 3});
                add(new Integer[]{7, 5});
                add(new Integer[]{7, 6});
                add(new Integer[]{7, 7});
                add(new Integer[]{7, 8});
                add(new Integer[]{0, 4});
                add(new Integer[]{1, 4});
                add(new Integer[]{2, 4});
                add(new Integer[]{3, 4});
                add(new Integer[]{4, 4});
                add(new Integer[]{5, 4});
                add(new Integer[]{6, 4});
                add(new Integer[]{8, 4});
            }
        };

        Piece reine = factory.blanche("Reine");

        ArrayList<Integer[]> zone = reine.zoneDeDeplacement();

        AssertBetweenArray(attendu, zone);

    }*/

}