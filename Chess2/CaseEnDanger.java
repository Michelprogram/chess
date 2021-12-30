package Chess2;

public class CaseEnDanger implements ComportementCase {
    @Override
    public String setCouleur() {
        return Couleur.ANSI_RED_BACKGROUND.getValue();
    }
}
