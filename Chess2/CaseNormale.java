package Chess2;

public class CaseNormale implements ComportementCase {
    @Override
    public String setCouleur() {
        return Couleur.ANSI_WHITE_BACKGROUND.getValue();
    }
}
