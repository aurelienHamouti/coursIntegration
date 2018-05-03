package vue;

import java.util.Observable;
import java.util.Observer;
import java.awt.List;
import metier.ListePays;
import metier.Action;

public class ObsPourLstPays implements Observer {
    private List lst;

    public ObsPourLstPays (List lst) { this.lst = lst; }

    public void update (Observable o, Object arg) {
        switch (((Action)arg).getAction()) {
            case Action.LOAD: lst.removeAll(); for (int i=0; i < ((ListePays)o).size(); i++) { lst.add(((ListePays)o).getPays(i).toString()); } break;
        }
    }
}