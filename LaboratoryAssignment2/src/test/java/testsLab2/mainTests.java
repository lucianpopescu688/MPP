package testsLab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import com.google.common.collect.Lists;


public class mainTests {
    @Test
    void testListNotEmpty() {
        List<String> items = Lists.newArrayList("BetterCallSaul", "BreakingBad", "Rick&Morty", "BlackMirror");
        assertFalse(items.isEmpty(), "List should not be empty");
    }

    @Test
    void testListSize() {
        List<String> items = Lists.newArrayList("BetterCallSaul", "BreakingBad", "Rick&Morty", "BlackMirror");
        assertEquals(4, items.size(), "List should contain 4 items");
    }

}