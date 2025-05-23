import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {
    
    @Test
    public void test() {
        assertEquals(2, 1*2);
    }

    @Test
    public void failTest() {
        assertEquals(2, 1+2);
    }
}
