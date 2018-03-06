package Recursion;

import java.util.List;

public final class Exam2008Question5 {

    /** The Number of occurrences of elem in list.
     *  @ensure result >= 0
     */
    public static <T> int recursiveCount(List<T> list, T elem) {
        if (list.size() == 0) {
            return 0;
        }
        if (list.get(0).equals(elem)) {
            return 1 + recursiveCount(list.subList(1, list.size()), elem);
        } else {
            return recursiveCount(list.subList(1, list.size()), elem);
        }
    }

    /** The Number of occurrences of elem in list.
     *  @ensure result >= 0
     */
    public static <T> int count(List<T> list, T elem) {
        int count = 0; //the result.
        // Loop invariant: count == number of occurrences of elem with index less than i
        for (int i=0; i < list.size(); i++) {
            if (list.get(i).equals(elem)) {
                count++;
            }
        }
        return count;
    }
}

