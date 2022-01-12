package echec.pattern.chess.cases;

import echec.pattern.chess.utils.Couleur;

public class CaseEnDanger implements ComportementCase {
    @Override
    public String setCouleur() {
        return Couleur.ANSI_RED_BACKGROUND.getValue();
    }
}
