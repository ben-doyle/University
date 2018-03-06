package tut1;

/** Tutorial 1 from CSSE7023
 * @author Benjamin Doyle
 * @version 1.0
 */
public class Tutorial1Static {

    public static void main (String[] args) {

        //Test 1 - sum()
        int[] testArray = {1, 2 ,3};
        System.out.println("sum(): Expected 6, got: " + sum(testArray));

        //Test 2 - countArray()
        int[] testArray2 = {1, 1, 4, 1, 5};
        System.out.println("countArray(): Expected 3, got: " +
                countItem(1, testArray2));

        //Test3 - sumArray()
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {2, 3, 4, 5};
        int[] array3 = new int[4];
        sumArray(array1, array2, array3);
        String s = new String();
        for (int a : array3) {
            s += (a + ", ");
        }
        System.out.println("sumArray(): Expected 3, 5, 7, 9, got: " + s);

        //Test 4 - prefix
        String s1 = "Magic";
        String s2 = "Magical";
        System.out.println("prefix(): Expected: true, got: " + prefix(s1, s2));
    }


    /**
     * The function sum(int [] a) returns the sum of the elements in the
     * array of integers a.
     * @param a is the array that will be summed.
     */
    public static int sum(int[] a) {

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
    public static int countItem(int v, int[] a) {

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
    public static void sumArray(int[] a, int[] b, int[] c) {

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
    public static boolean prefix(String s1, String s2) {

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
