package Chess2;

public class Case {
    private String couleur;
    private String nom;
    private Integer[] position;
    private ComportementCase comportementCase;

    public Case(String nom, Integer[] position){
        this.nom = nom;
        this.position = position;

        //couleur de la case en fonction de son état
        this.setComportementCase(new CaseNormale());
    }

    public void setComportementCase(ComportementCase comportementCase){
        this.comportementCase = comportementCase;
        this.couleur = this.comportementCase.setCouleur();
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
