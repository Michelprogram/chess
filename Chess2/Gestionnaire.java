package Chess2;

public class Gestionnaire {
    public static void main(String[] args){
        Plateau plateau = new Plateau();
        Affichage affichage = new Affichage(plateau);

        affichage.afficher();

        //test - obtention d'une case
        Case c = plateau.getCase("h6");
        System.out.println(c.getPosition()[0] + " : " + c.getPosition()[1]);

        //test - affichage de la piècesur la case
        System.out.println(plateau.getPiece(c));

    }
}
