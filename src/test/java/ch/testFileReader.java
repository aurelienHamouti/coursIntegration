package ch;


import dao.FileReader;
import dao.SportDao;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.containsString;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testFileReader {
    private SportDao dao;
    private FileReader reader;

    @BeforeMethod
    protected void setUp()
    {
        reader = mock(FileReader.class);
     
        
    }

    @Test
    public void shouldReturnEmptyListWhenArrayEmpty()
    {
        when(reader.readAthletes()).thenReturn(new String[]{});
        
        String[] lstr = reader.readAthletes();
        assertThat(lstr.toString().length()<1, is(false));
        
        
    }
    
    @Test
    public void shouldBeParseList()
    {
        String[] lst = reader.readAthletes();
        assertThat(lst[0], containsString(";"));
    }
    
}
