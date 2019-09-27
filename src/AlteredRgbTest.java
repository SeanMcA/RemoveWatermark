import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class AlteredRgbTest {
	int red;
	int green;
	int blue;
	
	 @Before
	 public void executedBeforeEach() {
	 }

    @Test
    public void alteredRgbTestMethod() {    	
        // assert statements
        assertEquals(139, red, 1); // (Expected, actual, margin for error)
        assertEquals(121, green, 1);
        assertEquals(114, blue, 1);
    }
}