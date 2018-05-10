
import dao.FileReader;
import dao.PaysDao;
import dao.SportDao;
import metier.Action;
import java.util.Observable;
import metier.ListeAthletes;
import metier.ListePays;
import metier.ListeSports;
import static org.mockito.Mockito.mock;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import vue.ObsPourLstAthletes;
import vue.ObsPourLstPays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aurélien Hamouti
 */
public class TestVueForm {
     
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
        
        ObsPourLstAthletes obs = new ObsPourLstAthletes(new vue.FrmMain().getlstAthletes());
        obs.update(p, new Action(2));
       
        assertEquals(p.getPays(), p2.getPays());
    }
    
    
    
}
