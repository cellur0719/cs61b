import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars(){
        boolean judge1 = offByOne.equalChars('a', 'b');
        boolean judge2 = offByOne.equalChars('%', '&');
        boolean judge3 = offByOne.equalChars('%', 'a');
        assertTrue(judge1);
        assertTrue(judge2);
        assertFalse(judge3);
    }
}