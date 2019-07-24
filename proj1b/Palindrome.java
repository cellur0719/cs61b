public class Palindrome{
    public Deque<Character> wordToDeque(String word){
        ArrayDeque<Character> rtn = new ArrayDeque<>();
        for(int i = 0; i < word.length(); i++){
            rtn.addLast(word.charAt(i));
        }
        return rtn;
    }

    public boolean isPalindrome(String word){
        Deque<Character> w = wordToDeque(word);
        return isPalindrome(w);
    }

    private boolean isPalindrome(Deque<Character> w){
        int size = w.size();
        if(size <= 1) return true;
        char first = w.removeFirst();
        char last = w.removeLast();
        if(first != last) return false;
        else return isPalindrome(w);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> w = wordToDeque(word);
        return isPalindrome(w, cc);
    }

    private boolean isPalindrome(Deque<Character> w, CharacterComparator cc){
        int size = w.size();
        if(size <= 1) return true;
        char first = w.removeFirst();
        char last = w.removeLast();
        if(!cc.equalChars(first, last)) return false;
        else return isPalindrome(w, cc);
    }
}
