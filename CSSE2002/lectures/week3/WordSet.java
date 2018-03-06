package week3;

import java.util.ArrayList;

/**
 * A mutable, unbounded sets of words.
 */
public class WordSet {

    // a hash table implementation
    private final static int SIZE = 101; // size of the table
    private ArrayList<ArrayList<String>> hashTable; // the elements of the set

    /*
     * invariant:
     * 
     * hashTable != null &&
     * 
     * lists of hashTable are not null &&
     * 
     * elements of hashTable.get(i) are not null &&
     * 
     * each element of hashTable.get(i) has 
     *      i == |(hashCode of element) modulo SIZE| &&
     *      no duplicates in hashTable
     */

    /**
     * Creates an empty WordSet.
     */
    public WordSet() {
        hashTable = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < SIZE; i++) {
            hashTable.add(new ArrayList<String>());
        }
    }

    /**
     * Returns the key for a given word.
     *
     * @param word the word
     */
    private int key(String word) {
        return Math.abs(word.hashCode() % SIZE);
    }

    /**
     * Adds a non-null word to this WordSet.
     *
     * @param word the word to be added to the set
     * @throws NullPointerException if the word to be added is null
     */
    public void add(String word) {
        if (word == null) {
            throw new NullPointerException("word must not be null");
        }
        ArrayList<String> list = hashTable.get(key(word));
        if (!list.contains(word)) {
            list.add(word);
        }
    }

    /**
     * Removes a word from this WordSet.
     *
     * @param word the word to be removed from the set
     */
    public void remove(String word) {
        ArrayList<String> list = hashTable.get(key(word));
        list.remove(word);
    }

    /**
     * Determines if a word is a member of this WordSet.
     *
     * @param word the word to be checked
     * @return true if the given word is a member of this WordSet, and false
     * otherwise
     */
    public boolean contains(String word) {
        ArrayList<String> list = hashTable.get(key(word));
        return list.contains(word);
    }

    /**
     * Determines the size of this WordSet.
     *
     * @return the number of elements in this WordSet.
     */
    public int size() {
        int size = 0;
        for (int i = 0; i < SIZE; i++) {
            size += hashTable.get(i).size();
        }
        return size;
    }

    /**
     * Determines whether this WordSet is internally consistent.
     *
     * @return true if this WordSet is internally consistent, and false
     * otherwise
     */
    public boolean checkInvariant() {
        if (hashTable == null || nullLists() || nullElements()) {
            return false;
        }
        if (!keysCorrect()) {
            return false;
        }
        if (duplicateElements()) {
            return false;
        }
        return true;
    }

    /**
     * Determines whether there are null lists in the hash table.
     *
     * @return whether there are null lists
     */
    private boolean nullLists() {
        for (int i = 0; i < SIZE; i++) {
            if (hashTable.get(i) == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines whether there are null elements in the lists of the hash
     * table.
     *
     * @return whether there are null elements
     */
    private boolean nullElements() {
        for (int i = 0; i < SIZE; i++) {
            ArrayList<String> list = hashTable.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == null) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines whether words are stored in the correct position in the hash
     * table.
     *
     * @return whether the words are in the correct position
     */
    private boolean keysCorrect() {
        for (int i = 0; i < SIZE; i++) {
            // the ith list in the hash table
            ArrayList<String> list = hashTable.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (Math.abs(list.get(j).hashCode() % SIZE) != i) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Determines whether there are duplicate elements in the hash table.
     *
     * @return whether there are duplicate elements
     */
    private boolean duplicateElements() {
        for (int i = 0; i < SIZE; i++) {
            if (duplicateElements(hashTable.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines whether there are duplicate elements in a given list.
     *
     * @param list the list
     * @return whether there are duplicate elements in list
     */
    private boolean duplicateElements(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i); // the ith word in list
            for (int j = i + 1; j < list.size(); i++) {
                if (word.equals(list.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String string = "["; // the string representation of the WordSet
        for (int i = 0; i < SIZE; i++) {
            // the ith list in the hash table
            ArrayList<String> list = hashTable.get(i);
            // the string representation of the ith list
            String listString = list.toString();
            if (!list.isEmpty()) {
                if (!string.equals("[")) {
                    string += ", ";
                }
                string += listString.substring(1, listString.length() - 1);
            }
        }
        return string + "]";
    }

}
