package Chess2;

import chess.piece.FactoryPiece;
import chess.piece.Piece;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;

public class Plateau implements Sujet {
    private List<Observateur> observateurs;
    private List<Piece> pieces;
    private Map<Case,Piece> cases;

    public Plateau(){
        this.observateurs = new ArrayList<>();
        this.pieces = new ArrayList<>(32);//le plateau contient 32 pièces au début de la partie
        this.cases = new LinkedHashMap<>(64);//le plateau contient 64 cases
        this.initPlateau();

        this.notifierObs();//met à jour l'affichage
        for(Piece p : cases.values()){
            if(p!=null) pieces.add(p);
        }
    }

    private void initPlateau() {
        FactoryPiece factoryPiece = new FactoryPiece();//création de la factory

        //--première rangée pièces noires
        Piece tourNoire = factoryPiece.noire("Tour");
        Piece tourNoire2 = factoryPiece.noire("Tour");
        Piece cavalierNoir = factoryPiece.noire("Cavalier");
        Piece cavalierNoir2 = factoryPiece.noire("Cavalier");
        Piece fouNoir = factoryPiece.noire("Fou");
        Piece fouNoir2 = factoryPiece.noire("Fou");
        Piece roiNoir = factoryPiece.noire("Roi");
        Piece reineNoir = factoryPiece.noire("Reine");

        cases.put(new Case("a1", new Integer[]{0, 0}), tourNoire);
        cases.put(new Case("b1", new Integer[]{0, 1}), cavalierNoir);
        cases.put(new Case("c1", new Integer[]{0, 2}), fouNoir);
        cases.put(new Case("d1", new Integer[]{0, 3}), roiNoir);
        cases.put(new Case("e1", new Integer[]{0, 4}), reineNoir);
        cases.put(new Case("f1", new Integer[]{0, 5}), fouNoir2);
        cases.put(new Case("g1", new Integer[]{0, 6}), cavalierNoir2);
        cases.put(new Case("h1", new Integer[]{0, 7}), tourNoire2);

        //--deuxième rangée pion
        for (int i = 0; i < 8; i++) {
            String lettre = Convertisseur.toLetter(i);
            Piece pion = factoryPiece.noire("Pion");
            cases.put(new Case(lettre + "2", new Integer[]{1, i}), pion);
        }

        //--4 rangées vides au centre du plateau
        for (int i = 3; i <= 6; i++) {
            for (int j = 0; j < 8; j++) {
                String lettre = Convertisseur.toLetter(j);
                String nomCase = lettre + i;
                Case ca = new Case(nomCase, new Integer[]{i, j});
                cases.put(ca, null);
            }
        }

        //--avant-dernière rangée pions blancs
        for (int i = 0; i < 8; i++) {
            String lettre = Convertisseur.toLetter(i);
            Piece pion = factoryPiece.blanche("Pion");
            cases.put(new Case(lettre + "7", new Integer[]{6, i}), pion);
        }

        //--dernière rangée pièces blanches
        Piece tourBlanche = factoryPiece.blanche("Tour");
        Piece tourBlanche2 = factoryPiece.blanche("Tour");
        Piece cavalierBlanc = factoryPiece.blanche("Cavalier");
        Piece cavalierBlanc2 = factoryPiece.blanche("Cavalier");
        Piece fouBlanc = factoryPiece.blanche("Fou");
        Piece fouBlanc2 = factoryPiece.blanche("Fou");
        Piece roiBlanc = factoryPiece.blanche("Roi");
        Piece reineBlanche = factoryPiece.blanche("Reine");

        cases.put(new Case("a8", new Integer[]{7, 0}), tourBlanche);
        cases.put(new Case("b8", new Integer[]{7, 1}), cavalierBlanc);
        cases.put(new Case("c8", new Integer[]{7, 2}), fouBlanc);
        cases.put(new Case("d8", new Integer[]{7, 3}), roiBlanc);
        cases.put(new Case("e8", new Integer[]{7, 4}), reineBlanche);
        cases.put(new Case("f8", new Integer[]{7, 5}), fouBlanc2);
        cases.put(new Case("g8", new Integer[]{7, 6}), cavalierBlanc2);
        cases.put(new Case("h8", new Integer[]{7, 7}), tourBlanche2);
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
    public void deplacerPiece(Piece piece,Case ancienneCase,Case nouvelleCase){
        //vérifier si le déplacement est possible. Si oui :

        piece.setPositionNumber(nouvelleCase.getPosition());//la pièce adopte la position de la nouvelle case
        cases.replace(nouvelleCase,piece);//on dépose la pièce sur la nouvelle case choisie
        cases.replace(ancienneCase,null);//l'ancienne case devient vide
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
