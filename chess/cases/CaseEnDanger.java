package chess.cases;

import Chess2.Couleur;

public class CaseEnDanger implements ComportementCase {
    @Override
    public String setCouleur() {
        return Couleur.ANSI_RED_BACKGROUND.getValue();
    }
}
