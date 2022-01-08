package Chess2;

import chess.piece.Piece;

public class Joueur {
    private String nom;
    private boolean couleur;
    private Plateau plateau;

    public Joueur(String nom,String couleur,Plateau plateau){
        this.nom = nom;
        this.plateau = plateau;
        if(couleur=="blanc") this.couleur = true;
        else if(couleur=="noir") this.couleur = false;
    }

    public boolean getCouleur(){
        return this.couleur;
    }
}
