package echec.pattern.chess.cases;

import echec.pattern.chess.utils.Couleur;

public class CasePossible implements ComportementCase {
    @Override
    public String setCouleur() {
        return Couleur.ANSI_YELLOW_BACKGROUND.getValue();
    }
}
