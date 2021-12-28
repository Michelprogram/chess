public class Gestionnaire {
    public static void main(String[] args){
        Plateau plateau = new Plateau();
        Affichage affichage = new Affichage(plateau);

        affichage.afficher();
    }
}
