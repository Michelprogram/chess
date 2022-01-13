package echec.pattern.chess.observer;

public interface Sujet {
    void enregistrerObs(Observateur o);
    void supprimerObs(Observateur o);
    void notifierObs();
}
