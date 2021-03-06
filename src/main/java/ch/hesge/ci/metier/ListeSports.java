package metier;

import dao.FileReader;
import dao.PaysDao;
import dao.SportDao;
import domaine.Sport;
import java.util.Observer;

public class ListeSports extends ListeObjects {

    public ListeSports(Observer observer) {
        super(observer);
        aListe = new SportDao(new FileReader()).getListeSports();
        setChanged(); notifyObservers(new Action(Action.LOAD));
   }

    
    public Sport getSport() { return (Sport)super.get(); }
    public Sport getSport(int pos) { return (Sport)super.get(pos); }
}