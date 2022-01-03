package chess.cases;

import Chess2.Couleur;

public class CaseNormale implements ComportementCase {
    @Override
    public String setCouleur() {
        return Couleur.ANSI_WHITE_BACKGROUND.getValue();
    }
}
