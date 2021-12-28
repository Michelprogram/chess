public class Case {
    private String couleur;
    private String nom;
    private int[][] position;
    private ComportementCase comportementCase;

    public Case(String nom,String couleur,int[][] position){
        this.nom = nom;
        this.couleur = couleur;
        this.position = position;
        this.comportementCase = new CaseNormale();
    }

    public void setCouleur(){
        this.comportementCase.setCouleur();
    }

    public void setComportementCase(ComportementCase comportementCase){
        this.comportementCase = comportementCase;
    }

    public int[][] getPosition(){
        return this.position;
    }
}
