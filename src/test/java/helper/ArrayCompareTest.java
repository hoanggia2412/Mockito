package helper;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayCompareTest {

    @Test
    void test(){
        int[] numbers  = {1,2,3,4,5};
        int[] expected = {1,3,2,4,5};
        Arrays.sort(expected);
        assertArrayEquals(numbers,expected);
    }

    @Test
    void test2(){
        int[] numbers  = null;
       assertThrows(NullPointerException.class,() -> Arrays.sort(numbers));
    }
}