package tut8;

public class D extends A {
    /**
     * @require str!=null && str.length() <= 5
     * @ensure \result.length == str.length() &&
     * for each index i in \result,
     * \result[i] == str.charAt(i)
     */
    public char[] getChars(String str) {
        // ASSUME THAT A VALID IMPLEMENTATION IS HERE
        return null;
    }
}

//Answer: The precondition is strengthened (in relation to A), which means this is not good.
