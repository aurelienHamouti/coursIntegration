package metier;

import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;

/**
 * Liste d'Objects Observable avec une position courante
 * - abstract: aucune instance de ce composant ne doit être créée
 * - visibilité protected (sous-class): outil de base pour créer des listes spécialisées dans le package.
 */
abstract class ListeObjects extends Observable {

    protected ArrayList aListe;             /* Liste des Objects */
    public static final int NO_POS = -1;    /* Valeur de la position courante non définie */
    private int posCrt = NO_POS;            /* La position courante: initialement, pas de position courante */
    
    protected ListeObjects() {}
    protected ListeObjects(Observer obs) { if (obs != null) { addObserver(obs); } }

    /** Retourne le nombre d'Objects de la liste. */
    public final int size() { return aListe.size(); }

    /** Retourne la position courante. NO_POS s'il n'y en a pas. */
    public final int getPos() { return posCrt; }

    /** Définit la position courante. NO_POS signifie qu'il n'y en a pas. */
    public final void setPos(int pos) {
        if (pos != posCrt) {
            posCrt = (pos >= 0 && pos < aListe.size()) ? pos : NO_POS;
            setChanged(); notifyObservers(new Action(Action.SEL, posCrt));
        }
    }

    /** Retourne l'Object courant, null si la position courante n'est pas correctement définie. */
    protected Object get() {
        if (posCrt < 0 || posCrt >= aListe.size()) { return null; }
        return aListe.get(posCrt);
    }

    /** Retourne l'Object d'indice pos, null si pos n'est pas correctement défini. */
    protected Object get(int pos) {
        if (pos < 0 || pos >= aListe.size()) { return null; }
        return aListe.get(pos);
    }
}