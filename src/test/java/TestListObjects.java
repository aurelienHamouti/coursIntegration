
import dao.AthleteDao;
import dao.FileReader;
import dao.PaysDao;
import dao.SportDao;
import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;
import java.util.ArrayList;
import java.util.List;
import metier.ListePays;
import metier.ListeSports;
import metier.ListeAthletes;


import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vue.ObsPourLstAthletes;
import vue.ObsPourLstPays;
import vue.ObsPourLstSports;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aurélien Hamouti
 */
public class TestListObjects {
    
    private ListePays listePays;
    private ListeSports listeSports;
    private ListeAthletes listeAthletes;
    private SportDao daoS;
    private PaysDao daoP;
    private FileReader reader;

    @BeforeMethod
    protected void setUp()
    {
        listePays = mock(ListePays.class);
        listeSports = mock(ListeSports.class);
        listeAthletes = mock(ListeAthletes.class);
        
        daoS = new SportDao(reader);
        daoP = new PaysDao(reader);
    }
    
    ////////////// test des getteurs ////////////////////
    
    @Test
    public void TestgetPaysListePays()
    {
        ListePays p = new ListePays(new ObsPourLstPays(new vue.FrmMain().getLstPays()));
        ListePays p2 = new ListePays(new ObsPourLstPays(new vue.FrmMain().getLstPays()));
        assertEquals(p.getPays(), p2.getPays());
    }
    
    @Test
    public void TestgetSportListeSport()
    {
        ListeSports p = new ListeSports(new ObsPourLstSports(new vue.FrmMain().getLstSports()));
        ListeSports p2 = new ListeSports(new ObsPourLstSports(new vue.FrmMain().getLstSports()));
        assertEquals(p.getSport(), p2.getSport());
    }
    
    @Test
    public void TestGetAthletesListe()
    {
        ListeAthletes p = new ListeAthletes(new ObsPourLstAthletes(new vue.FrmMain().getlstAthletes()));
        ListeAthletes p2 = new ListeAthletes(new ObsPourLstAthletes(new vue.FrmMain().getlstAthletes()));
        assertEquals(p.getAthlete(), p2.getAthlete());
        assertEquals(p.getAthlete(-1), p2.getAthlete(-1));
    }   
    
    ////////////// test chargement données ///////////////
    
    @Test
    public void TestChargementAthletesListe()
    {
        ListeAthletes p = new ListeAthletes(new ObsPourLstAthletes(new vue.FrmMain().getlstAthletes()));     
        Sport sport = new Sport(10,"sport1");
        Pays pays = new Pays(10);      
        p.charger(pays, sport);
        List<Athlete> lstAthlete = new AthleteDao(new FileReader()).getListeAthletes(pays,sport); 
        assertEquals(lstAthlete, p.getList());
    }   
    
    ///////////// test listObject ////////////
    
    @Test
    public void TestGetPosListe()
    {
        ListeAthletes p = new ListeAthletes(new ObsPourLstAthletes(new vue.FrmMain().getlstAthletes()));     
        Sport sport = new Sport(7,"Patinage");
        Pays pays = new Pays(61,"ESP","Espagne");      
        p.charger(pays, sport);
        int pos = 1;
        p.setPos(pos);
        assertEquals(pos, p.getPos());
    } 
    
    @Test
    public void TestGetObjectList()
    {
        ListeAthletes p = new ListeAthletes(new ObsPourLstAthletes(new vue.FrmMain().getlstAthletes()));     
        Sport sport = new Sport(13,"Ski alpin");
        Pays pays = new Pays(179,"SUI","Suisse"); 
        p.charger(pays, sport); 
        int pos = 1;
        p.setPos(pos);
        Athlete athlete = new Athlete(436,"Carlo","JANKA",pays,sport) ;
        assertEquals(athlete, p.getAthlete(pos));
        assertTrue(p.getAthlete(pos) instanceof Object);
    } 
    
    @Test
    public void TestGetListe()
    {
        ListeAthletes p = new ListeAthletes(new ObsPourLstAthletes(new vue.FrmMain().getlstAthletes()));     
        Sport sport = new Sport(13,"Ski alpin");
        Pays pays = new Pays(179,"SUI","Suisse"); 
        p.charger(pays, sport); 
        
        assertEquals(p.getList().get(0), p.getAthlete(0));
    }   
    
    
            
}
