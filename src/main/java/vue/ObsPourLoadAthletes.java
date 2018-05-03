package vue;

import java.util.Observable;
import java.util.Observer;
import metier.ListeAthletes;
import metier.Action;
import metier.ListePays;
import metier.ListeSports;

public class ObsPourLoadAthletes implements Observer {
    private ListePays listePays;
    private ListeSports listeSports;
    private ListeAthletes listeAthletes;
    
    public ObsPourLoadAthletes (ListeAthletes listeAthletes, ListePays listePays, ListeSports listeSports) { this.listeAthletes=listeAthletes; this.listePays=listePays; this.listeSports=listeSports; }

    public void update (Observable o, Object arg) {
        switch (((Action)arg).getAction()) {
            case Action.SEL: if (listePays.getPays() != null && listeSports.getSport() != null) { listeAthletes.charger(listePays.getPays(), listeSports.getSport()); } break;
        }
    }
}