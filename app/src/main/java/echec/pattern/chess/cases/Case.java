package echec.pattern.chess.cases;

//Définis une case du plateaux
public class Case {

    private String couleur;
    private String nom;
    private Integer[] position;

    public Case(String nom, Integer[] position){
        this.nom = nom;
        this.position = position;

        //couleur de la case en fonction de son état
        this.setComportementCase(new CaseNormale());
    }

    public void setComportementCase(ComportementCase comportementCase){
        this.couleur = comportementCase.setCouleur();
    }

    public String getNom(){
        return this.nom;
    }

    public Integer[] getPosition(){
        return this.position;
    }

    public String toString(){
        return this.couleur;
    }
}
