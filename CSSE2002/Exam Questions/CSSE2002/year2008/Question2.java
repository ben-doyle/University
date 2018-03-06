package CSSE2002.year2008;

import java.util.List;

public class Question2 {
     /** The number of occurrences of elem in list.
     * @ensure result >= 0
     */
    public static <T> int count(List<T> list, T elem) {
        int count = 0; // the result
        for (int i=0; i < list.size(); i++) {
            if (list.get(i).equals(elem))
                count++;
        }
        return count;
    }
}


