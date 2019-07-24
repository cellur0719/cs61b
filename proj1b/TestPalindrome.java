import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        Boolean actual1 = palindrome.isPalindrome("a");
        Boolean actual2 = palindrome.isPalindrome("apple");
        Boolean actual3 = palindrome.isPalindrome("");
        Boolean actual4 = palindrome.isPalindrome("asdfdsa");
        Boolean actual5 = palindrome.isPalindrome("panshu");
        assertTrue(actual1);
        assertTrue(actual3);
        assertFalse(actual2);
        assertTrue(actual4);
        assertFalse(actual5);
    }

    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testIsPalindrome2(){
        boolean actua11 = palindrome.isPalindrome("apple", offByOne);
        boolean actual2 = palindrome.isPalindrome("a", offByOne);
        boolean actual3 = palindrome.isPalindrome("brcfdsa", offByOne);
        boolean actual4 = palindrome.isPalindrome("%&", offByOne);
        boolean actual5 = palindrome.isPalindrome("%!", offByOne);
        assertFalse(actua11);
        assertTrue(actual2);
        assertTrue(actual3);
        assertTrue(actual4);
        assertFalse(actual5);
    }
}