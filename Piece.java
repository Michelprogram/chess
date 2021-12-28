import java.util.List;

public abstract class Piece {
    protected String caractere;
    protected int[][] position;
    protected String couleur;
    protected boolean menace;
    //  protected List<Integer[][]> deplacementsPossibles;

    public Piece(int[][] position,String couleur){
        this.position = position;
        this.couleur = couleur;
        this.menace = false;

        //initialisation des déplacements possibles
    }

    //déplace la pièce sur une case
    /*public void deplacer(Case case){

    }*/

    public String toString(){
        return this.caractere   ;
    }
}
