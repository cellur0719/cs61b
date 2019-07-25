import org.junit.Test;
import static org.junit.Assert.*;
public class Testsort {
    /** Test the Sort.sort method. */
    @Test
    public void testSort(){
        String[] raw = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(raw);

        assertArrayEquals(expected, raw);

        /*
        for(int i = 0; i < raw.length; i++) {
            if (!raw[i].equals(expected[i])) {
                System.out.println("Mismatch in position" + i + ", expected: " + expected[i] + ", but got: " + raw[i]);
                return;
            }
        }
        /* Java.util.Arrays.equals(raw, expected) can also be used. */

    }
    @Test
    public void testFindSmallest(){
        String[] raw = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(raw, 1);

        assertEquals(expected, actual);

        String[] raw2 = {"there", "are", "many", "pigs"};
        int expected2 = 2;

        int actual2 = Sort.findSmallest(raw2, 2);

        org.junit.Assert.assertEquals(expected2, actual2);
    }
    @Test
    public void testSwap(){
        String[] raw = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};
        Sort.Swap(raw, a, b);
        assertArrayEquals(expected, raw);
    }


}
