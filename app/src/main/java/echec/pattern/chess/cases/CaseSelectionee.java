package echec.pattern.chess.cases;

import echec.pattern.chess.utils.Couleur;

public class CaseSelectionee implements ComportementCase {
    @Override
    public String setCouleur() {
        return Couleur.ANSI_CYAN_BACKGROUND.getValue();
    }
}
