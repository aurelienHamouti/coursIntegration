package dao;

import java.util.ArrayList;
import java.util.StringTokenizer;
import outils.FileStr;
import domaine.Pays;

public class PaysDao {
    
    private static final String FICHIER_PAYS = "Pays.txt";

    
    public PaysDao(FileReader reader) {
    }

    public static ArrayList getListePays() {//retourne la liste des pays
        String[] tabPays = FileStr.read(FICHIER_PAYS);
        ArrayList aLst = new ArrayList();
        for (int i=0; i<tabPays.length; i++) { 
            StringTokenizer strT = new StringTokenizer(tabPays[i], ";");
            aLst.add(new Pays(Integer.parseInt(strT.nextToken()), strT.nextToken(), strT.nextToken()));
        }
        return aLst;
    }   
}