package Chess2;

public interface Sujet {
    public void enregistrerObs(Observateur o);
    public void supprimerObs(Observateur o);
    public void notifierObs();
}
