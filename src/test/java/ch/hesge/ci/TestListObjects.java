package ch.hesge.ci;



import dao.AthleteDao;
import dao.FileReader;
import dao.PaysDao;
import dao.SportDao;
import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;
import java.util.ArrayList;
import vue.FrmMain;
import java.util.List;
import metier.ListePays;
import metier.ListeSports;
import metier.ListeAthletes;

import metier.Action;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
 
import java.util.ArrayList;
import java.util.List;
 
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import vue.ObsPourDetail;
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
    //private ObsPourLoadAthletes obsPourLoadAthletes;

    @BeforeMethod
    protected void setUp()
    {
        listePays = mock(ListePays.class);
        listeSports = mock(ListeSports.class);
        listeAthletes = mock(ListeAthletes.class);
        //obsPourLoadAthletes = mock(ObsPourLoadAthletes.class);
        
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
    public void TestGetListeAthletes()
    {
        ListeAthletes p = new ListeAthletes(new ObsPourLstAthletes(new vue.FrmMain().getlstAthletes()));     
        Sport sport = new Sport(13,"Ski alpin");
        Pays pays = new Pays(179,"SUI","Suisse"); 
        p.charger(pays, sport); 
        assertEquals(p.getList().get(0), p.getAthlete(0));
    }   
    
    @Test
    public void TestLoadListeAthletes()
    {/*
        ListeAthletes lstAthletes = new ListeAthletes(new ObsPourLstAthletes(new vue.FrmMain().getlstAthletes()));     
        ListePays lstPays = new ListePays(new ObsPourLstPays(new vue.FrmMain().getLstPays()));
        ListeSports lstSports = new ListeSports(new ObsPourLstSports(new vue.FrmMain().getLstSports()));
        //ListeAthletes p = new ListeAthletes(new ObsPourLoadAthletes(lstAthletes,lstPays,lstSports) );     
        Sport sport = new Sport(13,"Ski alpin");
        Pays pays = new Pays(179,"SUI","Suisse"); 
        p.charger(pays, sport); 
        
        List<Athlete> lstAthlete = new AthleteDao(new FileReader()).getListeAthletes(pays,sport); 
        assertEquals(p.getList().get(0), p.getAthlete(0));
        assertTrue(p instanceof ListeAthletes);
        assertEquals(lstAthlete, p.getList());
        
        //obsPourLoadAthletes.update(p, pays);
        //verify(obsPourLoadAthletes).update(p, pays);*/
    }
    
    @Test
    public void TestDetailsListe()
    {
        ListeAthletes listeAthletes = new ListeAthletes(new ObsPourLstAthletes(new vue.FrmMain().getlstAthletes()));     
        FrmMain frm = new vue.FrmMain();
        //listeAthletes.addObserver(new ObsPourDetail(frm.getTfNo(), frm.getTfPrenom(), frm.getTfNom(), frm.getTfPays(), frm.getTfSport()));
        
        Sport sport = new Sport(13,"Ski alpin");
        Pays pays = new Pays(179,"SUI","Suisse"); 
        listeAthletes.charger(pays, sport); 
        List<Athlete> lstAthlete = new AthleteDao(new FileReader()).getListeAthletes(pays,sport); 
        assertEquals(listeAthletes.getList().get(0), listeAthletes.getAthlete(0));
        assertTrue(listeAthletes instanceof ListeAthletes);
        assertEquals(lstAthlete, listeAthletes.getList());
    }
    
    @Test
    public void TestListe()
    {
        //obsPourLoadAthletes.update(listeAthletes, new Action(1));
    }
      
}
