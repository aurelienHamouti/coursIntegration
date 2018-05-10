package dao;

import java.util.ArrayList;
import java.util.StringTokenizer;
import outils.FileStr;
import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;

public class AthleteDao {
    
    public AthleteDao(FileReader reader){}
    
    private static final String FICHIER_ATHLETES = "Athletes.txt";

    public ArrayList getListeAthletes() {
        String[] tabAthletes = FileStr.read(FICHIER_ATHLETES);
        ArrayList aLst = new ArrayList();
        for (int i=0; i<tabAthletes.length; i++) {
            StringTokenizer strT = new StringTokenizer(tabAthletes[i], ";");
             aLst.add(strT.nextToken());
        }
        return aLst;
    }
    
    public ArrayList getListeAthletes(Pays pays, Sport sport) {
        String[] tabAthletes = FileStr.read(FICHIER_ATHLETES);
        ArrayList aLst = new ArrayList();
        for (int i=0; i<tabAthletes.length; i++) {
            StringTokenizer strT = new StringTokenizer(tabAthletes[i], ";");
            Pays p = new Pays(Integer.parseInt(strT.nextToken()));
            Sport s = new Sport(Integer.parseInt(strT.nextToken()));
            if (p.equals(pays) && s.equals(sport)) { aLst.add(new Athlete(Integer.parseInt(strT.nextToken()), strT.nextToken(), strT.nextToken(), pays, sport)); }
        }
        return aLst;
    }   
}