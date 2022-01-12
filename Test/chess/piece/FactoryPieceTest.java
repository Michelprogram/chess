package chess.piece;

import chess.piece.pieces.Reine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class FactoryPieceTest{

    private final FactoryPiece factoryPiece = new FactoryPiece();

    //Si les coordonnées sont bons après plusieurs instanciations d'une même pièce de la même couleur
    @Test
    public void position() throws Exception{

        Integer[] position1 = new Integer[]{6, 0};
        Integer[] position2 = new Integer[]{6, 1};


        Piece p1 = factoryPiece.blanche("Pion");
        Piece p2 = factoryPiece.blanche("Pion");

        assertArrayEquals(p1.getPositionNumber(), position1);
        assertArrayEquals(p2.getPositionNumber(), position2);

    }

    //Si la création de la pièce est bonne
    @Test
    public void InstanceOf() throws Exception{
        assertTrue(factoryPiece.blanche("Roi") instanceof Piece);
        assertFalse(factoryPiece.blanche("Roi") instanceof Reine);
    }

    //Si les coordonnées des pièces blanches sont cohérentes
    @Test
    public void pieceBlanche() throws Exception{

        ArrayList<Integer[]> attendu = new ArrayList<Integer[]>(){
            {
                //Les pions
                add(new Integer[]{6,0});
                add(new Integer[]{6,1});
                add(new Integer[]{6,2});
                add(new Integer[]{6,3});
                add(new Integer[]{6,4});
                add(new Integer[]{6,5});
                add(new Integer[]{6,6});
                add(new Integer[]{6,7});

                //Les tours
                add(new Integer[]{7,0});
                add(new Integer[]{7,7});

                //Les cavaliers
                add(new Integer[]{7,1});
                add(new Integer[]{7,6});

                //Les fous
                add(new Integer[]{7,2});
                add(new Integer[]{7,5});

                //Roi et Reine
                add(new Integer[]{7,3});
                add(new Integer[]{7,4});
            }
        };

        ArrayList<Integer[]> resultat = new ArrayList<>();

        int nbPion = 8;
        int nbPionIntermediaire = 3;

        for (int i = 0; i < nbPion; i++) {
            factoryPiece.blanche("Pion");
        }

        for (int i = 0; i < nbPionIntermediaire; i++) {
            if(i == 0){
                factoryPiece.blanche("Tour");
                factoryPiece.blanche("Tour");
            }
            else if(i == 1){
                factoryPiece.blanche("Cavalier");
                factoryPiece.blanche("Cavalier");
            }
            else{
                factoryPiece.blanche("Fou");
                factoryPiece.blanche("Fou");
            }
        }

        factoryPiece.blanche("Roi");
        factoryPiece.blanche("Reine");

        FactoryPiece.whitePieces.forEach( piece -> resultat.add(piece.getPositionNumber()));

        for (int i = 0; i < attendu.size(); i++) {

            Integer[] tab1 = attendu.get(i);
            Integer[] tab2 = resultat.get(i);

            assertArrayEquals(tab1, tab2);
        }

    }

    //Si les coordonnées des pièces noires sont cohérentes
    @Test
    public void pieceNoire() throws Exception{

        ArrayList<Integer[]> attendu = new ArrayList<Integer[]>(){
            {
                //Les pions
                add(new Integer[]{1,0});
                add(new Integer[]{1,1});
                add(new Integer[]{1,2});
                add(new Integer[]{1,3});
                add(new Integer[]{1,4});
                add(new Integer[]{1,5});
                add(new Integer[]{1,6});
                add(new Integer[]{1,7});

                //Les tours
                add(new Integer[]{0,0});
                add(new Integer[]{0,7});

                //Les cavaliers
                add(new Integer[]{0,1});
                add(new Integer[]{0,6});

                //Les fous
                add(new Integer[]{0,2});
                add(new Integer[]{0,5});

                //Roi et Reine
                add(new Integer[]{0,3});
                add(new Integer[]{0,4});
            }
        };

        ArrayList<Integer[]> resultat = new ArrayList<>();

        int nbPion = 8;
        int nbPionIntermediaire = 3;

        for (int i = 0; i < nbPion; i++) {
            factoryPiece.noire("Pion");
        }

        for (int i = 0; i < nbPionIntermediaire; i++) {
            if(i == 0){
                factoryPiece.noire("Tour");
                factoryPiece.noire("Tour");
            }
            else if(i == 1){
                factoryPiece.noire("Cavalier");
                factoryPiece.noire("Cavalier");
            }
            else{
                factoryPiece.noire("Fou");
                factoryPiece.noire("Fou");
            }
        }

        factoryPiece.noire("Roi");
        factoryPiece.noire("Reine");

        FactoryPiece.blackPieces.forEach( piece -> resultat.add(piece.getPositionNumber()));

        for (int i = 0; i < attendu.size(); i++) {

            Integer[] tab1 = attendu.get(i);
            Integer[] tab2 = resultat.get(i);

            assertArrayEquals(tab1, tab2);
        }

    }

    //Pas vraiment un test juste avoir une description de chaque pièce blanche
    @Test
    public void affichagePiece(){
        int nbPion = 8;
        int nbPionIntermediaire = 3;

        for (int i = 0; i < nbPion; i++) {
            factoryPiece.blanche("Pion");
        }

        for (int i = 0; i < nbPionIntermediaire; i++) {
            if(i == 0){
                factoryPiece.blanche("Tour");
                factoryPiece.blanche("Tour");
            }
            else if(i == 1){
                factoryPiece.blanche("Cavalier");
                factoryPiece.blanche("Cavalier");
            }
            else{
                factoryPiece.blanche("Fou");
                factoryPiece.blanche("Fou");
            }
        }

        factoryPiece.blanche("Roi");
        factoryPiece.blanche("Reine");

        FactoryPiece.whitePieces.forEach(System.out::println);
    }
}