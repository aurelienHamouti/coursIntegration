package ch.hesge.ci;






import ch.hesge.ci.*;
import outils.FileStr;
import outils.Validation;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.testng.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aurélien Hamouti
 */
public class TestOutils {
    
     protected void setUp()
    {/*
        FileStr = mock(FileStr.class);
      FileStr t = new FileStr();
      */
    }
/*
    @Test
    public void shouldReturnEmptyListWhenArrayEmpty()
    {
        fileStr
        
        when(fileStr.).thenReturn(new String[]{});
        List<Athlete> athlete = new AthleteDao(new FileReader()).getListeAthletes();
        assertThat(athlete.isEmpty(), is(false));         
    }
       */         
    @Test
    public void shouldBeArraylist()
    {
      if(Validation.isIntValid("1")){
          System.out.print("test réussi");
      };
        
    }
    
}
