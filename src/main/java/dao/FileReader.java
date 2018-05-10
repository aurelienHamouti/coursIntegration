package dao;

import outils.FileStr;

public class FileReader {
    
    public FileReader(){}

    private static final String FICHIER_PAYS = "Pays.txt";
    private static final String FICHIER_SPORTS = "Sports.txt";
    private static final String FICHIER_ATHLETES = "Athletes.txt";

    public String[] readPays() {return FileStr.read(FICHIER_PAYS);}
    public String[] readSports() {return FileStr.read(FICHIER_SPORTS);}
    public String[] readAthletes() {return FileStr.read(FICHIER_ATHLETES);}
}