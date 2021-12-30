package Chess2;

import chess.piece.FactoryPiece;
import chess.piece.Piece;

import java.util.*;

public class Plateau implements Sujet {
    private List<Observateur> observateurs;
    private List<Piece> pieces;
    private Map<Case,Piece> cases;
    private FactoryPiece factoryPiece;

    public Plateau(){
        this.observateurs = new ArrayList<>();
        this.pieces = new ArrayList<>(32);//le plateau contient 32 pièces au début de la partie
        this.cases = new LinkedHashMap<>(64);//le plateau contient 64 cases
        this.factoryPiece = new FactoryPiece();

        Piece tourNoire = factoryPiece.blanche("Tour");
        Piece tourNoire2 = factoryPiece.blanche("Tour");
        Piece cavalierNoir = factoryPiece.blanche("Cavalier");
        Piece cavalierNoir2 = factoryPiece.blanche("Cavalier");
        Piece fouNoir = factoryPiece.blanche("Fou");
        Piece fouNoir2 = factoryPiece.blanche("Fou");
        Piece roiNoir = factoryPiece.blanche("Roi");
        Piece reineNoir = factoryPiece.blanche("Reine");

        cases.put(new Case(Arrays.toString(tourNoire.getPositionLetter()), tourNoire.getPositionNumber()),tourNoire);
        cases.put(new Case(Arrays.toString(cavalierNoir.getPositionLetter()), cavalierNoir.getPositionNumber()),cavalierNoir);
        cases.put(new Case(Arrays.toString(fouNoir.getPositionLetter()), fouNoir.getPositionNumber()),fouNoir);
        cases.put(new Case(Arrays.toString(roiNoir.getPositionLetter()), roiNoir.getPositionNumber()),roiNoir);
        cases.put(new Case(Arrays.toString(reineNoir.getPositionLetter()), reineNoir.getPositionNumber()),reineNoir);
        cases.put(new Case(Arrays.toString(fouNoir2.getPositionLetter()), fouNoir2.getPositionNumber()),fouNoir2);
        cases.put(new Case(Arrays.toString(cavalierNoir2.getPositionLetter()), cavalierNoir2.getPositionNumber()),cavalierNoir2);
        cases.put(new Case(Arrays.toString(tourNoire2.getPositionLetter()), tourNoire2.getPositionNumber()),tourNoire2);

        for (int i = 0; i<8; i++) {
            //factoryPiece.blanche("Pion");
            //String lettre = Convertisseur.toLetter(i);
            Piece pion = factoryPiece.noire("Pion");
            cases.put(new Case(Arrays.toString(pion.getPositionLetter()), pion.getPositionNumber()),pion);
        }

        //--4 rangées vides au centre du plateau
        for(int i=0;i<8;i++){
            for(int j=2;j<6;j++){
                String lettre = Convertisseur.toLetter(i);
                Case ca = new Case(lettre+(j),new Integer[]{i,j});
                cases.put(ca,null);
            }
        }

        for (int i = 0; i<8; i++) {
            //factoryPiece.blanche("Pion");
            //String lettre = Convertisseur.toLetter(i);
            Piece pion = factoryPiece.blanche("Pion");
            cases.put(new Case(Arrays.toString(pion.getPositionLetter()), pion.getPositionNumber()),pion);
        }

        Piece tourBlanche = factoryPiece.blanche("Tour");
        Piece tourBlanche2 = factoryPiece.blanche("Tour");
        Piece cavalierBlanc = factoryPiece.blanche("Cavalier");
        Piece cavalierBlanc2 = factoryPiece.blanche("Cavalier");
        Piece fouBlanc = factoryPiece.blanche("Fou");
        Piece fouBlanc2 = factoryPiece.blanche("Fou");
        Piece roiBlanc = factoryPiece.blanche("Roi");
        Piece reineBlanche = factoryPiece.blanche("Reine");

        cases.put(new Case(Arrays.toString(tourBlanche.getPositionLetter()), tourBlanche.getPositionNumber()),tourBlanche);
        cases.put(new Case(Arrays.toString(cavalierBlanc.getPositionLetter()), cavalierBlanc.getPositionNumber()),cavalierBlanc);
        cases.put(new Case(Arrays.toString(fouBlanc.getPositionLetter()), fouBlanc.getPositionNumber()),fouBlanc);
        cases.put(new Case(Arrays.toString(roiBlanc.getPositionLetter()), roiBlanc.getPositionNumber()),roiBlanc);
        cases.put(new Case(Arrays.toString(reineBlanche.getPositionLetter()), reineBlanche.getPositionNumber()),reineBlanche);
        cases.put(new Case(Arrays.toString(fouBlanc2.getPositionLetter()), fouBlanc2.getPositionNumber()),fouBlanc2);
        cases.put(new Case(Arrays.toString(cavalierBlanc2.getPositionLetter()), cavalierBlanc2.getPositionNumber()),cavalierBlanc2);
        cases.put(new Case(Arrays.toString(tourBlanche2.getPositionLetter()), tourBlanche2.getPositionNumber()),tourBlanche2);

        /*
        //création des pièces
        //--première rangée noir
        cases.put(new Case("a1",new int[]{0,0}),factoryPiece.noire("Tour"));
        cases.put(new Case("b1",new int[]{1,0}),factoryPiece.noire("Cavalier"));
        cases.put(new Case("c1",new int[]{2,0}),factoryPiece.noire("Fou"));
        cases.put(new Case("d1",new int[]{3,0}),factoryPiece.noire("Roi"));
        cases.put(new Case("e1",new int[]{4,0}),factoryPiece.noire("Reine"));
        cases.put(new Case("f1",new int[]{5,0}),factoryPiece.noire("Fou"));
        cases.put(new Case("g1",new int[]{6,0}),factoryPiece.noire("Cavalier"));
        cases.put(new Case("h1",new int[]{7,0}),factoryPiece.noire("Tour"));

        //--deuxième rangée pions noir
        for(int i=0;i<8;i++){
            String lettre = Convertisseur.toLetter(i);
            cases.put(new Case(lettre+"2",new int[]{i,1}),factoryPiece.noire("Pion"));
        }

        //--4 rangées vides au centre du plateau
        for(int i=0;i<8;i++){
            for(int j=2;j<6;j++){
                String lettre = Convertisseur.toLetter(i);
                Case ca = new Case(lettre+(j),new int[]{i,j});
                cases.put(ca,null);
            }
        }

        //--avant-dernière rangée pions blanc
        for(int i=0;i<8;i++){
            String lettre = Convertisseur.toLetter(i);
            cases.put(new Case(lettre+"7",new int[]{i,6}),factoryPiece.blanche("Pion",new int[]{i,6}));
        }

        //--dernière rangée blanc
        Tour t = factoryPiece.blanche("Tour");

        cases.put(new Case("a8",new int[]{0,7}),factoryPiece.blanche("Tour",new int[]{0,7}));
        cases.put(new Case("b8",new int[]{1,7}),factoryPiece.blanche("Cavalier",new int[]{1,7}));
        cases.put(new Case("c8",new int[]{2,7}),factoryPiece.blanche("Fou",new int[]{2,7}));
        cases.put(new Case("d8",new int[]{3,7}),factoryPiece.blanche("Roi",new int[]{3,7}));
        cases.put(new Case("e8",new int[]{4,7}),factoryPiece.blanche("Reine",new int[]{4,7}));
        cases.put(new Case("f8",new int[]{5,7}),factoryPiece.blanche("Fou",new int[]{5,7}));
        cases.put(new Case("g8",new int[]{6,7}),factoryPiece.blanche("Cavalier",new int[]{6,7}));
        cases.put(new Case("h8",new int[]{7,7}),factoryPiece.blanche("Tour",new int[]{7,7}));
*/
        this.notifierObs();//met à jour l'affichage

        for(Piece p : cases.values()){
            if(p!=null) pieces.add(p);
        }
    }

    //renvoie une case en fonction de son nom
    public Case getCase(String nom){
        Case caseRecherchee = null;
        for(Case c : cases.keySet()){
            if(c.getNom().equals(nom)){
                caseRecherchee = c;
                break;
            }
        }
        return caseRecherchee;
    }

    //renvoie la pièce qui se situe sur la case c
    public Piece getPiece(Case c){
        if(c != null){
            return cases.get(c);
        }
        return null;
    }

    //renvoie l'état de toutes les cases
    public Map<Case,Piece> getCases(){
        return this.cases;
    }

    //déplace une pièce sur une case du plateau
    public void deplacerPiece(Piece piece,Case newCase){
    }

    //----------------------observateur----------------------------
    @Override
    public void enregistrerObs(Observateur o) {
        if(!this.observateurs.contains(o))
            this.observateurs.add(o);
    }

    @Override
    public void supprimerObs(Observateur o) {
        if(this.observateurs.contains(o))
            this.observateurs.remove(o);
    }

    @Override
    public void notifierObs() {
        for (Observateur observateur : this.observateurs) {
            observateur.actualiser();
        }
    }
}
