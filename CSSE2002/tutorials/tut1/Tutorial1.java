package tut1;

public class Tutorial1 {
    public Tutorial1() {

    }

    /**
     * The function sum(int [] a) returns the sum of the elements in the
     * array of integers a.
     */
    public int sum(int[] a) {

        int runningTotal = 0;
//        // NOTE: This way is using the larger for loop
//        for (int i = 0; i < a.length; i++) {
//            runningTotal += a[i];
//        }
        for (int v : a) {
            runningTotal += v;
        }
        return runningTotal;
    }

    /**
     * The function countItem(int v, int [] a) returns the number of times
     * the value v appears
     * in the array of integers a.
     */
    public int countItem(int v, int[] a) {

        int runningCount = 0;
//        // NOTE: This way is using the larger for loop
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] == v) {
//                runningCount++;
//            }
//        }
        for (int w : a) {
            if (w == v) {
                runningCount++;
            }
        }
        return runningCount;
    }

    /**
     * @require c.length <= a.length <= b.length
     * The method sumArray(int [] a, int [] b, int [] c) sets
     * each element in the array c to be the sum of the elements at the
     * same position in a and b.
     */
    public void sumArray(int[] a, int[] b, int[] c) {

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] + b[i];
        }
    }

    /**
     * The function prefix(String s1, String s2) returns whether or not
     * the string s1 is a prefix of string s2. Hint: The class String has
     * methods length(), to return the length of a string, and charAt(int n)
     * to return the char at position n.
     */
    public boolean prefix(String s1, String s2) {

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
            if (s1.charAt(i) == s2.charAt(i) && i == (s1.length() - 1)) {
                return true;
            }
        }
        return false;
    }
}
