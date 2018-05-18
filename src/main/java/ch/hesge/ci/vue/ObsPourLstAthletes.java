package vue;

import java.util.Observable;
import java.util.Observer;
import java.awt.List;
import metier.ListeAthletes;
import metier.Action;

public class ObsPourLstAthletes implements Observer {
    private List lst;

    public ObsPourLstAthletes (List lst) { this.lst = lst; }

    public void update (Observable o, Object arg) {
        switch (((Action)arg).getAction()) {
            case Action.LOAD: lst.removeAll(); ((ListeAthletes)o).setPos(ListeAthletes.NO_POS); for (int i=0; i < ((ListeAthletes)o).size(); i++) { lst.add(((ListeAthletes)o).getAthlete(i).toString()); } break;
        }
    }
    
}