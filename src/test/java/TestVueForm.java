
import dao.FileReader;
import dao.PaysDao;
import dao.SportDao;
import metier.Action;
import java.util.Observable;
import metier.ListeAthletes;
import metier.ListePays;
import metier.ListeSports;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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
    private ObsPourLstAthletes obs;

    @BeforeMethod
    protected void setUp()
    {
        obs = mock(ObsPourLstAthletes.class);
        listeSports = mock(ListeSports.class);
        listeAthletes = mock(ListeAthletes.class);
        
       
    }
    
    
    @Test
    public void TestUpdateObserver()
    {
        
        ListeAthletes p = new ListeAthletes(new ObsPourLstAthletes(new vue.FrmMain().getlstAthletes()));   
        ObsPourLstAthletes obs = new ObsPourLstAthletes(new vue.FrmMain().getlstAthletes());
        

//assertTrue();
        //verify
        //installer bit pour les tests de mutants
    }
    
    
    
}
