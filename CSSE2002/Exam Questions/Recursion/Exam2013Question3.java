package Recursion;

public class Exam2013Question3 {
    public static void main(String[] args) {
        int[] ar = {1, 4, 5, 7, 8};
        System.out.println(ascending(ar));
        System.out.println(recursiveAscending(ar));
        int[] ar2 = {1, 4, 5, 7, 8, 4};
        System.out.println(ascending(ar2));
        System.out.println(recursiveAscending(ar2));
    }

    /**
     *  Returns true if and only if a is an array of ascending integers.
     *  Helper method
     */
    private static boolean recursiveAscending(int[] a) {
        return recursiveAscending(a, 0);
    }

    /**
     * Returns true if and only if a is an array of ascending integers.
     *
     * @require a != null
     * @ensure \result is true if for all indices j such that
     * 0 <= j < a.length-1, a[j] <= a[j+1]
     */
    private static boolean recursiveAscending(int[] a, int i) {
        if (i >= a.length - 1) {
            return true;
        } else if (a[i] <= a[i + 1]) {
            return recursiveAscending(a, ++i);
        }
        return false;
    }


    /**
     * Returns true if and only if a is an array of ascending integers.
     *
     * @require a != null
     * @ensure \result is true if for all indices j such that
     * 0 <= j < a.length-1, a[j] <= a[j+1]
     */
    public static boolean ascending(int[] a) {
        boolean result = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                result = false;
            }
        }
        return result;
    }
}
