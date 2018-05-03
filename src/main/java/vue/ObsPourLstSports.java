package vue;

import java.util.Observable;
import java.util.Observer;
import java.awt.List;
import metier.ListeSports;
import metier.Action;

public class ObsPourLstSports implements Observer {
    private List lst;

    public ObsPourLstSports (List lst) { this.lst = lst; }

    public void update (Observable o, Object arg) {
        switch (((Action)arg).getAction()) {
            case Action.LOAD: lst.removeAll(); for (int i=0; i < ((ListeSports)o).size(); i++) { lst.add(((ListeSports)o).getSport(i).toString()); } break;
        }
    }
}