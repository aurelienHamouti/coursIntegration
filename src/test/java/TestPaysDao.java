import dao.FileReader;
import java.util.List;
import dao.PaysDao;
import domaine.Pays;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.testng.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


public class TestPaysDao {
    private PaysDao dao;
    private FileReader reader;

    @BeforeMethod
    protected void setUp()
    {
        reader = mock(FileReader.class);
        dao = new PaysDao(reader);
    }

    @Test
    public void shouldReturnEmptyListWhenArrayEmpty()
    {
        when(reader.readPays()).thenReturn(new String[]{});
        List<Pays> pays = new PaysDao(new FileReader()).getListePays();
		assertThat(pays.isEmpty(), is(false));
    }


    @Test
    public void shouldReturnSingleListSportArrayHasOnline()
    {
      
        when(reader.readPays()).thenReturn(new String[]{"161;RSA;Afrique du Sud"});
        List<Pays> pays = new PaysDao(new FileReader()).getListePays();
        assertThat(pays,is(not(empty())));
        assertThat(pays,hasSize(93));
        assertThat(pays,hasItem(new Pays(161,"RSA","Afrique du Sud")));
        
    }
}
