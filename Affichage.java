import java.util.Map;

public class Affichage implements Observateur{
    private Map<Case,Piece> cases;
    private Plateau plateau;

    public Affichage(Plateau plateau){
        this.plateau = plateau;
        this.cases = plateau.getCases();
    }

    public void setPlateau(Plateau plateau){
        this.plateau = plateau;
    }

    @Override
    public void actualiser() {
        this.cases = this.plateau.getCases();
    }

    public void afficher(){
        //code pour affichage du plateau
    }
}
