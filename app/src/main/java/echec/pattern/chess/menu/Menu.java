package echec.pattern.chess.menu;

import echec.pattern.chess.plateau.*;

import echec.pattern.chess.cases.Case;
import echec.pattern.chess.piece.Piece;
import echec.pattern.chess.utils.Utils;

import java.util.ArrayList;
import java.util.Scanner;

//Classe menu qui gère l'intéraction avec les joueurs
public class Menu {

    private String choiceMenu;
    private String choiceCase;
    private Scanner scanner;
    private Plateau plateau;


    public Menu(){
        this.plateau = new Plateau();
        this.choiceMenu = "";
        this.choiceCase = "";
        this.scanner = new Scanner(System.in);
    }

    //Menu de début
    public void start(){

        System.out.println("----------- Bienvenue dans le jeux d'échecs 21 -----------");
        System.out.println("Que voulez vous faire ? (1 - 3)\n" +
                "1 - Lancer une partie\n" +
                "2 - Les règles\n" +
                "3 - Quitter");

        this.choiceMenu = scanner.next();

        switch (this.choiceMenu){
            case ("1"):
                game();
                break;
            case ("2"):
                regles();
                break;
            case("3"):
                quitter();
                break;
            default:
                Utils.resetTerminal();
                System.out.println("Choisir un nombre entre 1 et 3.");
                start();
                break;
        }

    }

    //Fct qui tourne en boucle durant le temps de la partie
    public void game(){


        ArrayList<Joueur> joueurs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        boolean deplacementIsOk;

        Case caseSource, caseDestination;
        Piece pieceSelectionnee;
        Joueur currentPlayer;

        int compteur = 0;

        for (int i = 0; i < 2; i++) {
            joueurs.add(creationJoueur(i));
        }

        Utils.resetTerminal();
        Affichage affichage = new Affichage(plateau);


        try{
            do{

                deplacementIsOk = false;
                currentPlayer = joueurs.get(compteur);
                System.out.println("C'est à " + currentPlayer + " de jouer." );

                System.out.print("Sélectionner une case : ");
                choiceCase = sc.nextLine();

                checkLeaveGame();

                caseSource = plateau.getCase(choiceCase);
                pieceSelectionnee = plateau.selectionnerPiece(currentPlayer,caseSource);

                while( pieceSelectionnee == null){
                    System.out.println("Impossible de sélectionner la pièce.");
                    System.out.print("Sélectionner une autre case : ");
                    choiceCase = sc.nextLine();

                    checkLeaveGame();

                    caseSource = plateau.getCase(choiceCase);
                    pieceSelectionnee = plateau.selectionnerPiece(currentPlayer, caseSource );
                }


                while(!deplacementIsOk){
                    System.out.print("Où voulez-vous déplacer la pièce ? : ");
                    choiceCase = sc.nextLine();

                    checkLeaveGame();

                    if(!choiceCase.equals("c")){

                        caseDestination = plateau.getCase(choiceCase);
                        deplacementIsOk = plateau.deplacerPiece(currentPlayer,pieceSelectionnee,caseSource,caseDestination);

                        if(!deplacementIsOk)
                            System.out.println("Le déplacement de la pièce est impossible.");
                        else{
                            compteur = compteur == 0 ? 1 : 0;
                        }

                    }else{
                        plateau.reinitialiserCases(true);
                        deplacementIsOk = true;
                    }

                }

            }while(!choiceCase.equals("q"));
        }
        catch (ErrorLeaveGame err){
            System.out.println(err.getMessage());
            start();
        }


    }

    //Crée deux joueurs qui s'affronte
    public Joueur creationJoueur(int idJoueur){
        String message = "Nom du " + (idJoueur == 0 ? "premier" : "second") + " joueur : ";
        String color = idJoueur == 0 ? "noir" : "blanc";

        System.out.print(message);

        choiceMenu = scanner.next();

        System.out.println(message + choiceMenu + " avec les pions " + color);

        return new Joueur(choiceMenu, color, plateau);
    }

    //Rappelle des règles
    public void regles(){

        System.out.println("--------- Règles ---------");
        System.out.println("Dans ce jeux d'échecs 2 joueurs s'affronte au tour par tour.");
        System.out.println("Les règles sont les mêmes que dans un jeux d'échecs classique.");
        System.out.println("Plus d'info ici : https://ecole.apprendre-les-echecs.com/regles-echecs/");
        System.out.println("Vous pouvez à tout moment arrêter le jeux en renseignant la lettre q.");

        while (!this.choiceMenu.equals("1")){
            System.out.println("Retour au menu ? (1)");

            this.choiceMenu = scanner.next();
        }

        start();

    }

    //Vérifie à chaque input possible si le joueur veut partir
    public void checkLeaveGame() throws ErrorLeaveGame {
        if (this.choiceCase.equals("q")){
            throw new ErrorLeaveGame("Fin de la partie");
        }
    }

    //Quitter l'application avec une attente de 5 secondes
    public void quitter(){

        System.out.println("A bientôt sur 21 chess game.");
        for (int i = 0; i < 5; i++) {
            try{
                Thread.sleep(1000);
                System.out.print(".");
            }catch(InterruptedException err){
                System.out.println("Problème de fermeture : " + err.getMessage());
                return;
            }
            Utils.resetTerminal();
        }
    }

    public static void main(String[] args) {

        Menu menu =  new Menu();

        menu.start();
    }

}
