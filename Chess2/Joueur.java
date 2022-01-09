package Chess2;

import chess.piece.Piece;

public class Joueur {
    private String nom;
    private boolean couleur;
    private Plateau plateau;

    public Joueur(String nom,String couleur,Plateau plateau){
        this.nom = nom;
        this.plateau = plateau;

        this.couleur = couleur.equals("blanc");

    }

    public boolean getCouleur(){
        return this.couleur;
    }

    @Override
    public String toString(){
        return nom + " couleur " + (couleur ? "blanc" : "noir");
    }
}
