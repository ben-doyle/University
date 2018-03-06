package extra.week3;

import java.util.*;
import java.io.*;

// comment out next line to test list implementation
import week3.WordSet;

/** Used to test the speed of different WordSet implementations. */
public class WordSetTimer {

	/**
	 * Creates a WordSet containing all the words in a text file and outputs how
	 * long it take to access each word one time.
	 * 
	 * @param args
	 *            An array whose first element is the name of the text file.
	 */
	public static void main(String[] args) throws IOException {
		WordSet words = new WordSet(); // the WordSet to test
		// a list of the words in w
		ArrayList<String> list = new ArrayList<String>();
		// a scanner to read the words in a text file
		Scanner s = new Scanner(new FileReader(args[0]));
		while (s.hasNext()) {
			// the next words in the text file
			String word = s.next();
			words.add(word);
			list.add(word);
		}
		s.close();
		System.out.println("size of WordSet: " + words.size() + " words");
		System.out.println("total time to access each of the words once: "
				+ accessTime(words, list) + " milliseconds");
	}

	/**
	 * Returns the time taken (in milliseconds) to determine whether each word
	 * in a list is contained in a WordSet.
	 * 
	 * @param words
	 *            The WordSet
	 * @param list
	 *            The list
	 */
	private static int accessTime(WordSet words, ArrayList<String> list) {
		// the time when this method is called
		double start = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			words.contains(list.get(i));
		}
		return (int) (System.currentTimeMillis() - start);
	}

}
