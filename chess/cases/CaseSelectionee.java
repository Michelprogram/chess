package chess.cases;

import Chess2.Couleur;

public class CaseSelectionee implements ComportementCase {
    @Override
    public String setCouleur() {
        return Couleur.ANSI_CYAN_BACKGROUND.getValue();
    }
}
