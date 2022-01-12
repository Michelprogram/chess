package echec.pattern.chess.cases;

import echec.pattern.chess.utils.Couleur;

public class CaseNormale implements ComportementCase {
    @Override
    public String setCouleur() {
        return Couleur.ANSI_WHITE_BACKGROUND.getValue();
    }
}
