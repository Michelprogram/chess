package Chess2;

import chess.cases.*;
import chess.piece.FactoryPiece;
import chess.piece.Piece;

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
        for (int i = 2; i <= 5; i++) {
            for (int j = 0; j < 8; j++) {
                String lettre = Convertisseur.toLetter(j);
                String nomCase = lettre + (i+1);
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
        String nomCase = nom.toLowerCase(Locale.ROOT);//on met le nom en minuscule pour être au bon format
        Case caseRecherchee = null;
        for(Case c : cases.keySet()){
            if(c.getNom().equals(nomCase)){
                caseRecherchee = c;
                break;
            }
        }
        return caseRecherchee;
    }

    //renvoie une case en fonction de sa position
    public Case getCase(Integer[] coordonne){
        Case caseRecherchee = null;
        for(Case c : cases.keySet()){
            if(Arrays.equals(c.getPosition(),coordonne)){
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

    //-------------------------------------------------------------------------
    //réduit la zone de déplacement d'une pièce en fonction de la position des autres pièces sur le plateau
    private void filterDeplacement(Piece piece){
        ArrayList<Integer[]> zoneDeplacement = piece.zoneDeDeplacement();
        ArrayList<Integer[]> nouvelleZoneDeplacement = new ArrayList<>();//copie affinée de la liste de déplacement

        //System.out.println("Cases possibles : ");
        for(Integer[] coordonneCase : zoneDeplacement){
            //System.out.println(Arrays.toString(coordonneCase));
            Case casePossible = this.getCase(coordonneCase);
            if(casePossible!=null) {//si la case existe
                if(cases.get(casePossible)!=null){//si la case possède une pièce
                    Piece p = cases.get(casePossible);//on récupère la pièce associée à la case
                    if(p.getCouleur() != piece.getCouleur()){//si la pièce est de l'équipe adverse
                        nouvelleZoneDeplacement.add(coordonneCase);
                        casePossible.setComportementCase(new CaseEnDanger());//je peux la manger
                    }
                }else{//si la case est vide
                    nouvelleZoneDeplacement.add(coordonneCase);
                    casePossible.setComportementCase(new CasePossible());
                }
            }
        }
        piece.setZoneRecalculee(nouvelleZoneDeplacement);//la pièce connait désormais ses nouvelles possibilitées de déplacement
    }
    //sélectionne une pièce et met en surbrillance la zone de déplacement
    public Piece selectionnerPiece(Case caseSelectionnee){
        caseSelectionnee.setComportementCase(new CaseSelectionee());
        Piece pieceSelectionnee = this.getPiece(caseSelectionnee);

        if(pieceSelectionnee!=null){//si la pièce existe
            this.filterDeplacement(pieceSelectionnee);//on récupère la zone de déplacement de la pièce
        }

        this.notifierObs();//met à jour l'affichage
        return pieceSelectionnee;
    }

    //déplace une pièce sur une case du plateau
    public void deplacerPiece(Piece piece,Case ancienneCase,Case nouvelleCase){
        System.out.println("Case destination : " + Arrays.toString(nouvelleCase.getPosition()));
        //vérifier si le déplacement est possible:
        for(Integer[] coordonne : piece.getZoneRecalculee()){
            if(Arrays.equals(coordonne,nouvelleCase.getPosition())){//si la case de destination se trouve dans la liste des déplacements possibles de la pièce
                piece.setPositionNumber(nouvelleCase.getPosition());//la pièce adopte la position de la nouvelle case
                cases.replace(nouvelleCase,piece);//on dépose la pièce sur la nouvelle case choisie
                cases.replace(ancienneCase,null);//l'ancienne case devient vide

                this.reinitialiserCases();//on réinitialise les états des cases
                return;
            }
        }
        System.out.println("Impossible de déplacer la pièce");
    }

    //réinitialise l'état des cases
    public void reinitialiserCases(){
        for(Case c : cases.keySet()){
            c.setComportementCase(new CaseNormale());
        }
        this.notifierObs();//met à jour l'affichage
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
