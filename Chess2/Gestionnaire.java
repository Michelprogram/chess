package Chess2;

import chess.cases.Case;
import chess.cases.CaseSelectionee;
import chess.piece.Piece;

import java.util.Arrays;
import java.util.Scanner;

public class Gestionnaire {
    public static void main(String[] args){
        Plateau plateau = new Plateau();
        Affichage affichage = new Affichage(plateau);
        Joueur daryl = new Joueur("Daryl","noir",plateau);
        Joueur dorian = new Joueur("Dorian","blanc",plateau);
        Joueur joueurCourant = daryl;

        Scanner sc = new Scanner(System.in);
        String nomCase; boolean deplacementOk;

        do{
            //test - obtention d'une case
            System.out.print("Entrer un nom de case : "); nomCase = sc.nextLine();
            Case caseSource = plateau.getCase(nomCase);
            Piece pieceSelectionnee = plateau.selectionnerPiece(joueurCourant,caseSource);

            if(pieceSelectionnee!=null){
                System.out.print("Où voulez-vous déplacer la pièce ? : "); nomCase = sc.nextLine();
                if(!nomCase.equals("c")){
                    Case caseDestination = plateau.getCase(nomCase);
                    deplacementOk = plateau.deplacerPiece(joueurCourant,pieceSelectionnee,caseSource,caseDestination);

                    if(!deplacementOk)
                        System.out.println("Impossible de déplacer la pièce");
                }else{
                    plateau.reinitialiserCases(true);
                }
            }else{
                System.out.println("Impossible de sélectionner la pièce");
            }
        }while(nomCase != "q");
    }
}
