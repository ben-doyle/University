package week4;

import java.util.*;

/** A mutable, unbounded sets of words. */
public class WordSet
        implements Iterable<String>, Cloneable {

    // the elements of the set
    private ArrayList<String> words;
    /*
     * invariant: words != null && 
     * each element of words !=null && 
     * no duplicates in words
     */

    /** Creates an empty WordSet. */
    public WordSet() {
        words = new ArrayList<String>();
    }

    /**
     * Adds a word to this WordSet.
     * @param word
     *            the word
     */
    public void add(String word) {
        if (word == null) {
            throw new NullPointerException();
        }
        if (!words.contains(word)) {
            words.add(word);
        }
    }

    /**
     * Removes a word from this WordSet.
     * @param word
     *            the word
     */
    public void remove(String word) {
        words.remove(word);
    }

    /**
     * Determines if a word is a member of this WordSet.
     * @param word
     *            the word
     * @return true if the given word is a member of this
     *         WordSet, and false otherwise
     */
    public boolean contains(String word) {
        return words.contains(word);
    }

    /**
     * Determines the size of this WordSet.
     * @return the number of elements in this WordSet
     */
    public int size() {
        return words.size();
    }

    @Override
    public Iterator<String> iterator() {
        return words.iterator();
    }

    @Override
    public Object clone() {
        WordSet copy = new WordSet();
        for (String s : words) {
            copy.add(s);
        }
        return copy;
    }

    @Override
    public String toString() {
        return words.toString();
    }

    /**
     * Determines whether this WordSet is internally
     * consistent.
     * @return true if this WordSet is internally
     *         consistent, and false otherwise
     */
    public boolean checkInvariant() {
        if (words == null || nullElements()) {
            return false;
        }
        if (duplicateElements()) {
            return false;
        }
        return true;
    }

    /**
     * Returns true if this WordSet has null elements,
     * otherwise return false.
     * @return whether this WordSet has null elements
     */
    private boolean nullElements() {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i) == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns true if this WordSet has duplicate elements,
     * otherwise return false.
     * @return whether this WordSet has duplicate elements
     */
    private boolean duplicateElements() {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i); // a word in words
            for (int j = i + 1; j < words.size(); j++) {
                if (word.equals(words.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
