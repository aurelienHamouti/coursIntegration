package metier;

import dao.AthleteDao;
import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;
import java.util.Observer;

public class ListeAthletes extends ListeObjects {

    public ListeAthletes(Observer observer) {
        super(observer);
   }

    public void charger(Pays p, Sport s) {
        aListe = AthleteDao.getListeAthletes(p, s);
        setChanged(); notifyObservers(new Action(Action.LOAD));
   }

    
    public Athlete getAthlete() { return (Athlete)super.get(); }
    public Athlete getAthlete(int pos) { return (Athlete)super.get(pos); }
}