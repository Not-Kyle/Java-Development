import java.util.ArrayList;

public class Wordset {
    private ArrayList<String> words;

    public Wordset() {
        this.words = new ArrayList<>();
    }

    public void add(String word) {
        this.words.add(word);
    }

    public void remove(String word) {
        this.words.remove(word);
    }

    public boolean contains(String word) {
        return this.words.contains(word);
    }

    public int palindromes() {
        int count = 0;

        for (String word : this.words) {
            if (isPalindrome(word)) {
                count++;
            }
        }

        return count;
    }

    public boolean isPalindrome(String word) {
        int endOfString = word.length() - 1; // - 1 because index starts at 0 and not 1

        int index = 0;
        while (index < word.length() / 2) { // Dividing by two so it will start at the middle | Example: level = l e v e l, starts at v and does v, e <-v-> e, l <- e <- v -> e -> l
            if (word.charAt(index) != word.charAt(endOfString - index)) {
                return false;
            }

            index++;
        }

        return true;
    }
}
