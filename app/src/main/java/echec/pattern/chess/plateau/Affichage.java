package echec.pattern.chess.plateau;


import echec.pattern.chess.cases.Case;
import echec.pattern.chess.piece.Piece;

import echec.pattern.chess.observer.Observateur;

import echec.pattern.chess.utils.Couleur;
import echec.pattern.chess.utils.Utils;


import java.util.Map;

//Affiche le tableau dans un terminal
public class Affichage implements Observateur {

    private Map<Case, Piece> cases;
    private Plateau plateau;

    public Affichage(Plateau plateau){
        this.plateau = plateau;
        plateau.enregistrerObs(this);
        this.cases = plateau.getCases();

        //affiche le jeu dès sa création
        this.afficher();
    }

    public void setPlateau(Plateau plateau){
        this.plateau = plateau;
    }

    @Override
    public void actualiser() {
        this.cases = this.plateau.getCases();
        Utils.resetTerminal();
        this.afficher();//affiche le nouveau plateau
    }


    //code pour affichage du plateau
    public void afficher(){
        //coordonees lettres
        System.out.print("\n");
        System.out.println(Couleur.ANSI_CYAN.getValue()+"  a     b     c     d     e     f     g     h  "+Couleur.ANSI_RESET.getValue());

        int compteur = 0;
        for(Map.Entry<Case,Piece> entry : cases.entrySet()){
            compteur++;
            String piece = entry.getValue()!=null ? entry.getValue().toString() : " ";
            System.out.print(entry.getKey() + "  " + piece + "  " + Couleur.ANSI_BLACK_BACKGROUND.getValue() +" " + Couleur.ANSI_RESET.getValue());

            if(compteur%8 == 0 && compteur!=64){
                System.out.print(Couleur.ANSI_CYAN.getValue()+compteur/8+"\n");//coordonee chiffre
                System.out.print(Couleur.ANSI_BLACK_BACKGROUND.getValue() + "                                                " + Couleur.ANSI_RESET.getValue()+"\n");
            }
        }
        System.out.println(Couleur.ANSI_CYAN.getValue()+"8"+Couleur.ANSI_RESET.getValue());//dernière coordonnée chiffrée
    }
}
