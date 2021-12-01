package business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class SpyTest {

    @Test
    public void test(){
        List array = Mockito.spy(ArrayList.class);
        Assertions.assertEquals(0,array.size());

        //mocks return default value
        Mockito.when(array.size()).thenReturn(5);
        array.add(5);
        Assertions.assertEquals(5,array.size());
        Mockito.verify(array).add(5);
    }
}
