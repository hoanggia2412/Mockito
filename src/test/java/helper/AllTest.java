package helper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayCompareTest.class,
        StringHelperTest.class
})
public class AllTest {

}