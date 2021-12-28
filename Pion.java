public class Pion extends Piece{
    private int nbCases;

    public Pion(int[][] position, String couleur) {
        super(position, couleur);
        this.caractere = "P";
        this.nbCases = 1;
    }
}
