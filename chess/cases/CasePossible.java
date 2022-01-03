package chess.cases;

import Chess2.Couleur;

public class CasePossible implements ComportementCase {
    @Override
    public String setCouleur() {
        return Couleur.ANSI_YELLOW_BACKGROUND.getValue();
    }
}
