package metier;

import dao.PaysDao;
import domaine.Pays;
import java.util.Observer;

public class ListePays extends ListeObjects {

    public ListePays(Observer observer) {
        super(observer);
        aListe = PaysDao.getListePays();
        setChanged(); notifyObservers(new Action(Action.LOAD));
   }

    
    public Pays getPays() { return (Pays)super.get(); }
    public Pays getPays(int pos) { return (Pays)super.get(pos); }
}