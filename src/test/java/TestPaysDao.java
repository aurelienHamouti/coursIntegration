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
        List<Pays> pays = dao.getListePays();
        assertThat(pays, empty());
    }


    @Test
    public void shouldReturnSingleListSportArrayHasOnline()
    {
        /*
        when(reader.readPays()).thenReturn(new String[]{"1'europe;allemagne"});
        List<Pays> pays = dao.getListePays();
        assertThat(pays,is(not(empty())));
        assertThat(pays,hasSize(1));
        assertThat(pays,contains(new Pays(1,"europe","allemagne")));
        */
    }
}
