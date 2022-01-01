package Chess2;

import chess.piece.Piece;

import java.util.Scanner;

public class Gestionnaire {
    public static void main(String[] args){
        Plateau plateau = new Plateau();
        Affichage affichage = new Affichage(plateau);
        Scanner sc = new Scanner(System.in);
        String nomCase;

        do{
            affichage.reset();
            affichage.afficher();

            //test - obtention d'une case
            System.out.print("Entrer un nom de case : "); nomCase = sc.nextLine();
            Case caseSource = plateau.getCase(nomCase);
            caseSource.setComportementCase(new CaseSelectionee());
            Piece piece = plateau.getPiece(caseSource);
            System.out.println(caseSource.getPosition()[1] + " : " + caseSource.getPosition()[0]);
            System.out.println(piece);//test - affichage de la pièce sur la case

            System.out.print("Où voulez-vous déplacer la pièce ? : "); nomCase = sc.nextLine();
            Case caseDestination = plateau.getCase(nomCase);
            caseDestination.setComportementCase(new CaseSelectionee());
            plateau.deplacerPiece(piece,caseSource,caseDestination);
        }while(nomCase != "q");
    }
}
