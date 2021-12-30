package Chess2;

public class CaseSelectionee implements ComportementCase {
    @Override
    public String setCouleur() {
        return Couleur.ANSI_CYAN_BACKGROUND.getValue();
    }
}
