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
        Scanner sc = new Scanner(System.in);
        String nomCase;

        do{
            //test - obtention d'une case
            System.out.print("Entrer un nom de case : "); nomCase = sc.nextLine();
            Case caseSource = plateau.getCase(nomCase);
            Piece pieceSelectionnee = plateau.selectionnerPiece(caseSource);

            System.out.print("Où voulez-vous déplacer la pièce ? : "); nomCase = sc.nextLine();
            if(!nomCase.equals("c")){
            Case caseDestination = plateau.getCase(nomCase);
            plateau.deplacerPiece(pieceSelectionnee,caseSource,caseDestination);}

            plateau.reinitialiserCases();
        }while(nomCase != "q");
    }
}
