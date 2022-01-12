package echec.pattern.chess.piece.pieces;

import echec.pattern.chess.piece.FactoryPiece;
import echec.pattern.chess.piece.Piece;

import java.util.ArrayList;

//Queen
//Déplacement partout sans limite
public class Reine extends Piece {
    public Reine(Boolean couleur,Integer[] position){
        super(couleur, position);
        this.character = 'Q';
        this.zone.addAll(DEPLACEMENT_CROIX);
        this.zone.addAll(DEPLACEMENT_LIGNE);
    }

    //Le déplacement de la reine combine le fou et tour, on crée un fou et une tour pour reprendre leur zone de
    // déplacement et les combiner.
    /*
    @Override
    public ArrayList<Integer[]> zoneDeDeplacement(){
        FactoryPiece factoryPiece = new FactoryPiece();

        Piece fou = getCouleur() ? factoryPiece.blanche("Fou") : factoryPiece.noire("Fou");
        Piece tour = getCouleur() ? factoryPiece.blanche("Tour") : factoryPiece.noire("Tour");

        //On place les pièces modèles au même emplacement que la reine
        fou.setPositionNumber(getPositionNumber());
        tour.setPositionNumber(getPositionNumber());

        //Récupère les cases jouables et l'ajoute au tableau zone de la reine
        fou.zoneDeDeplacement().forEach( position -> this.zone.add(position));
        tour.zoneDeDeplacement().forEach( position -> this.zone.add(position));

        //Pas besoin de filtrer, car déjà fais dans celui du fou et de la tour
        return this.zone;

    }*/

}
