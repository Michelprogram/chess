package Chess2;

public class CasePossible implements ComportementCase {
    @Override
    public String setCouleur() {
        return Couleur.ANSI_YELLOW_BACKGROUND.getValue();
    }
}
