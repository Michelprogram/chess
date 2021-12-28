import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Plateau implements Sujet{
    private List<Observateur> observateurs;
    private List<Piece> pieces;
    private Map<Case,Piece> cases;

    public Plateau(){
        this.observateurs = new ArrayList<>();
        this.pieces = new ArrayList<>(32);//le plateau contient 32 pièces au début de la partie
        this.cases = new HashMap<>(64);//le plateau contient 64 cases

        //création des pièces (utiliser la factory quand elle sera crée)
    }

    //renvoie une case en fonction de son nom
    public Case getCase(String nom){
        return null;
    }

    //renvoie l'état de toutes les cases
    public Map<Case,Piece> getCases(){
        return this.cases;
    }

    //déplace une pièce sur une case du plateau
    public void deplacerPiece(Piece piece,Case newCase){

    }

    //----------------------observateur----------------------------
    @Override
    public void enregistrerObs(Observateur o) {
        if(!this.observateurs.contains(o))
            this.observateurs.add(o);
    }

    @Override
    public void supprimerObs(Observateur o) {
        if(this.observateurs.contains(o))
            this.observateurs.remove(o);
    }

    @Override
    public void notifierObs() {
        for (Observateur observateur : this.observateurs) {
            observateur.actualiser();
        }
    }
}
