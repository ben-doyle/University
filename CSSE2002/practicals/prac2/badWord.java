package prac2;

import java.lang.Math;

public class badWord {

    public static void main(String[] args) {
        System.out.println(censor("street"));
    }

    /**
     * This method takes a non-empty string, randomly selects the index of a
     * character in the input string, and returns a copy of that string where
     * the character at the chosen index has been replaced by the character ‘*’.
     *
     * For example, censor("street") would return one of the strings
     * "*treet", "s*reet*, "st*eet", "str*et", "stre*t", "stree*", with equal
     * probability.
     *
     * @param badWord
     * the word to be censored
     * @return a censored representation of the input word.
     */
    public static String censor(String badWord) {
        int x = -1;
        while (x > badWord.length() - 1 || x == -1) {
            x = (int) (Math.random() * 10);
        }

        char[] c = badWord.toCharArray();
        c[x] = '*';
        String result = "";

        for (char c1: c) {
            result += c1;
        }
        return result;
    }


}
