package echec.pattern.chess.plateau;

//Joueur de l'application
public class Joueur {

    private String nom;
    private boolean couleur;

    public Joueur(String nom,String couleur,Plateau plateau){
        this.nom = nom;

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
