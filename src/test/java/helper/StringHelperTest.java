package helper;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringHelperTest {
    StringHelper helper =  new StringHelper();
    @Before
     void beforeAll(){
        System.out.println("before");
    }

    @Test
    void should_truncateAInFirst2Positions(){
        String expected = "CD";
        assertEquals(expected,helper.truncateAInFirst2Positions("AACD"));
    }

    @Test
    void should_truncateAInFirst2Position(){
        String expected = "CD";
        assertEquals("abc","ACD");
    }

    // ABCD -> false, ABAB -> true, AB -> true, A -> false
    @Test
    void should_areFirstAndLastTwoCharactersTheSame(){
       boolean actual = helper.areFirstAndLastTwoCharactersTheSame("ABCD");
      assertFalse(actual);

    }
}