package CSSE7023.year2016;

import java.util.ArrayList;
import java.util.List;

public class LongestSuffix {
    public static void main(String[] args) {

    }

    /**
     * Returns the longest suffix of the list x that has no
     * repeated elements
     *
     * @require x!= null && !x.contains(null)
     * @ensure This operation does not modify the input list x.
     *          It returns the longest suffix of the list x
     *          that has no repeated elements.
     */
    public static List<Integer> longestSuffix(List<Integer> x) {
        List<Integer> suffix = new ArrayList<>();
//        int j = x.size() - 1;
//        while (j >= 0) {
//            if (!suffix.contains(x.get(j))) {
//                // appends x.get(j) to the front of suffix
//                suffix.add(0, x.get(j));
//                j = j - 1;
//            } else {
//                j = -1;
//            }
//        }
        return suffix;
    }
}
