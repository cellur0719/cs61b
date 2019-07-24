import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testEqualChars(){
        boolean judge1 = offByN.equalChars('a', 'f');
        boolean judge2 = offByN.equalChars('f', 'a');
        boolean judge3 = offByN.equalChars('f', 'h');
        assertTrue(judge1);
        assertTrue(judge2);
        assertFalse(judge3);
    }
}
