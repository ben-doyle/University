package week2;

import java.util.ArrayList;

/**
 * A mutable, unbounded sets of words.
 */
public class WordSet {

    private ArrayList<String> words;

    public WordSet() {
        words = new ArrayList<String>();
    }

    public void add(String word) {
        if (!words.contains(word))
            words.add(word);
    }

    public void remove(String word) {
        words.remove(word);
    }

    public boolean contains(String word) {
        return words.contains(word);
    }

    public int size() {
        return words.size();
    }

    @Override
    public String toString() {
        return words.toString();
    }

}
