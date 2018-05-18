package ch.hesge.ci;




import ch.hesge.ci.*;
import domaine.Pays;
import domaine.Athlete;
import domaine.Sport;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 *
 * @author Aurélien Hamouti
 */
public class TestDomaineObjets {
    
    private Pays pays;
    private Sport sport;
    private Athlete athlete;

    @BeforeMethod
    protected void setUp()
    {
        pays = mock(Pays.class);
        sport = mock(Sport.class);
        athlete = mock(Athlete.class);
        
    }
    
    @Test
    public void equlalsTestSport()
    {
        Sport p = new Sport(11);
        Sport p2 = new Sport(11);
        assertEquals(p, p2);
    }
    
     @Test
    public void equlalsTestAthlete()
    {
        Athlete p = new Athlete(9,"athlete9Prenom","athlete9Nom",new Pays(),new Sport());
        Athlete p2 = new Athlete(9,"athlete9Prenom","athlete9Nom",new Pays(),new Sport());
        assertEquals(p, p2);
        assertTrue(p.equals(p2));
    }
    
    @Test
    public void equlalsTestPays()
    {
        Pays p = new Pays(10);
        Pays p2 = new Pays(10);
        assertEquals(p, p2);
    }  
    
    @Test
    public void toStringTestSport()
    {
        Sport p = new Sport(10,"sport1");
        Sport p2 = new Sport(10,"sport1");
        assertEquals(p.toString(), p2.toString());
    }
    
    public void toStringTestAthlete()
    {
        Athlete p = new Athlete(9,"athlete9Prenom","athlete9Nom",new Pays(),new Sport());
        assertTrue(p.toString() == "athlete9Prenom athlete9Nom");
    }
    
    @Test
    public void toStringTestPays()
    {
        Pays p = new Pays(10);
        Pays p2 = new Pays(10);
        assertEquals(p.toString(), p2.toString());
    }
    
    ///////////// Test Sport /////////////
    
    @Test
    public void concatenerStringTestSport()
    {
        Sport p = new Sport(10,"sport1");
        Sport p2 = new Sport(10,"sport1");
        assertEquals(p.concatenerString("123","456"), p2.concatenerString("123","456"));
    }
 
    @Test
    public void compareStringTestTestSport()
    {
        Sport p = new Sport(10,"sport1");
        Sport p2 = new Sport(10,"sport1");
        assertEquals(p.compareStringTest("123","123"), p2.compareStringTest("123","123"));
    }  
    
    
    ///////////// Test Athlete /////////////
    @Test
    public void getterTestAthlete()
    {
        Athlete p = new Athlete(9,"athlete9Prenom","athlete9Nom",new Pays(),new Sport());
        assertTrue(p.getNo() == 9);
        assertTrue(p.getNom() == "athlete9Nom");
        assertTrue(p.getPrenom() == "athlete9Prenom");
        assertTrue(p.getPays().equals(new Pays()));
        assertTrue(p.getSport().equals(new Sport()));
    } 
    
}
