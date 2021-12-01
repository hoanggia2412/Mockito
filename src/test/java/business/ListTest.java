package business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;

public class ListTest {
    @Test
    public void test(){
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.size()).thenReturn(1);

        listMock.add(2);
        listMock.add(3);

        Assertions.assertEquals(1,listMock.size());
    }

    @Test
    public void letMockListSize_ReturnMultipleValues(){
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.size()).thenReturn(2).thenReturn(3);
        Assertions.assertEquals(2,listMock.size());
        Assertions.assertEquals(3,listMock.size());
    }

    @Test
    public void letMockListGet(){
        List listMock = Mockito.mock(List.class);
        Mockito.when(listMock.get(0)).thenReturn("in28Minutes")
                .thenThrow(new NullPointerException("Some thing was wrong"));
        Assertions.assertEquals("in28Minutes",listMock.get(0));
        Assertions.assertThrows(NullPointerException.class,()->listMock.get(0));
    }
}
