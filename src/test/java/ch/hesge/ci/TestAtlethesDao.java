package ch.hesge.ci;




import ch.hesge.ci.*;
import dao.FileReader;
import java.util.List;
import dao.AthleteDao;
import dao.PaysDao;
import dao.SportDao;
import domaine.Athlete;
import domaine.Pays;
import domaine.Sport;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.testng.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


public class TestAtlethesDao {
    private AthleteDao daoA;
    private SportDao daoS;
    private PaysDao daoP;
    private FileReader reader;

    @BeforeMethod
    protected void setUp()
    {
        reader = mock(FileReader.class);
        daoA = new AthleteDao(reader);
        daoS = new SportDao(reader);
        daoP = new PaysDao(reader);
    }

    @Test
    public void shouldReturnEmptyListWhenArrayEmpty()
    {
        when(reader.readAthletes()).thenReturn(new String[]{});
        List<Athlete> athlete = new AthleteDao(new FileReader()).getListeAthletes();
        assertThat(athlete.isEmpty(), is(false));         
    }
                
    @Test
    public void shouldBeArraylist()
    {
        ArrayList lstSports = daoS.getListeSports();
        ArrayList lstPays = daoP.getListePays();
        List<Athlete> Athlete = new AthleteDao(new FileReader()).getListeAthletes((Pays)lstPays.get(0),(Sport)lstSports.get(0));
        assertTrue(Athlete instanceof ArrayList);
        
    }
    
    
}
