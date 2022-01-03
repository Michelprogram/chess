package Chess2;

import chess.cases.Case;
import chess.piece.Piece;

import java.util.Map;

public class Affichage implements Observateur {
    private Map<Case, Piece> cases;
    private Plateau plateau;

    public Affichage(Plateau plateau){
        this.plateau = plateau;
        this.cases = plateau.getCases();
    }

    public void setPlateau(Plateau plateau){
        this.plateau = plateau;
    }

    @Override
    public void actualiser() {
        this.cases = this.plateau.getCases();
    }

    public void reset(){

        String os = System.getProperty("os.name");
        String command = os.contains("Windows") ? "cls" : "clear";

        try{
            Runtime.getRuntime().exec(command);
        }
        catch (Exception err){
            System.out.println("Impossible de clear le terminal");
        }

        /*
        Si ne marche pas, essayer avec ça
                System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
         */
    }

    public void afficher(){
        //code pour affichage du plateau
        int compteur = 0;

        for(Map.Entry<Case,Piece> entry : cases.entrySet()){
            compteur++;
            String piece = entry.getValue()!=null ? entry.getValue().toString() : " ";
            System.out.print(entry.getKey() + "  " + piece + "  " + Couleur.ANSI_BLACK_BACKGROUND.getValue() +" " + Couleur.ANSI_RESET.getValue());

            if(compteur%8 == 0 && compteur != 64){
                System.out.print("\n");
                System.out.println(Couleur.ANSI_BLACK_BACKGROUND.getValue() + "                                                " + Couleur.ANSI_RESET.getValue());
            }
        }
    }
}
